package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.io.InputHandler;
import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.io.StudyCafeFileHandler;
import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePass;
import cleancode.studycafe.tobe.model.StudyCafePassType;

import java.util.List;

public class StudyCafePassMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    private final StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();
    private final List<StudyCafeLockerPass> lockerPasses = studyCafeFileHandler.readLockerPasses();

    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();

            outputHandler.askPassTypeSelection();

            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();
            StudyCafePass selectedPass = selectedPassByPassTypeFrom(studyCafePassType);
            StudyCafeLockerPass lockerPass = findMatchingLockerPass(selectedPass);

            if (lockerPass != null && selectedPass.isAvailableLockerPass()) {
                outputHandler.askLockerPass(lockerPass);
                if (inputHandler.getLockerSelection()) {
                    selectedPass.setLockerPass(lockerPass);
                }
            }

            outputHandler.showPassOrderSummary(selectedPass);
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private StudyCafeLockerPass findMatchingLockerPass(StudyCafePass selectedPass) {
        return lockerPasses.stream()
            .filter(option ->
                option.getPassType() == selectedPass.getPassType()
                    && option.getDuration() == selectedPass.getDuration()
            )
            .findFirst()
            .orElse(null);
    }

    private StudyCafePass selectedPassByPassTypeFrom(
        StudyCafePassType passType
    ) {
        List<StudyCafePass> studyCafePasses = studyCafeFileHandler.readStudyCafePasses();
        List<StudyCafePass> filteredPasses = studyCafePasses.stream()
            .filter(pass -> pass.getPassType() == passType)
            .toList();

        outputHandler.showPassListForSelection(filteredPasses);
        return inputHandler.getSelectPass(filteredPasses);
    }

}
