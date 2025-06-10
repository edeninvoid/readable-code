package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.provider.LockerPassProvider;
import cleancode.studycafe.tobe.provider.SeatPassProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafePassMachineTest {

    private final SeatPassProvider seatPassProvider;
    private final LockerPassProvider lockerPassProvider;

    StudyCafePassMachineTest(SeatPassProvider seatPassProvider, LockerPassProvider lockerPassProvider) {
        this.seatPassProvider = seatPassProvider;
        this.lockerPassProvider = lockerPassProvider;
    }

    @DisplayName("")
    @Test
    void test() {
        // given
        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(seatPassProvider, lockerPassProvider);
        studyCafePassMachine.run();

        // when

        // then
    }


}
