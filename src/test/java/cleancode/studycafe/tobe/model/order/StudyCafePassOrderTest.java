package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static cleancode.studycafe.tobe.model.pass.StudyCafePassType.FIXED;
import static cleancode.studycafe.tobe.model.pass.StudyCafePassType.HOURLY;
import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassOrderTest {

    @DisplayName("카페 이용권 주문의 할인 가격을 확인한다.")
    @Test
    void getDiscountPrice() {
        // given
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(HOURLY, 12, 13000, 0.0);
        StudyCafeLockerPass studyCafeLockerPass = StudyCafeLockerPass.of(FIXED, 12, 30000);
        StudyCafePassOrder studyCafePassOrder = StudyCafePassOrder.of(studyCafeSeatPass, studyCafeLockerPass);

        // then
        assertThat(studyCafePassOrder.getDiscountPrice()).isZero();
    }

    @DisplayName("카페 이용권 주문의 총 가격을 확인한다.")
    @Test
    void getTotalPrice() {
        // given
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(HOURLY, 12, 13000, 0.0);
        StudyCafeLockerPass studyCafeLockerPass = StudyCafeLockerPass.of(FIXED, 12, 30000);
        StudyCafePassOrder studyCafePassOrder = StudyCafePassOrder.of(studyCafeSeatPass, studyCafeLockerPass);

        // then
        assertThat(studyCafePassOrder.getTotalPrice()).isEqualTo(43000);
    }

    @DisplayName("카페 이용권 주문의 이용권을 확인한다.")
    @Test
    void getSeatPass() {
        // given
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(HOURLY, 12, 13000, 0.0);
        StudyCafeLockerPass studyCafeLockerPass = StudyCafeLockerPass.of(FIXED, 12, 30000);
        StudyCafePassOrder studyCafePassOrder = StudyCafePassOrder.of(studyCafeSeatPass, studyCafeLockerPass);

        // then
        assertThat(studyCafePassOrder.getSeatPass()).isEqualTo(studyCafeSeatPass);
    }

    @DisplayName("카페 이용권 주문의 사물함을 확인한다.")
    @Test
    void getLockerPass() {
        // given
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(HOURLY, 12, 13000, 0.0);
        StudyCafeLockerPass studyCafeLockerPass = StudyCafeLockerPass.of(FIXED, 12, 30000);
        StudyCafePassOrder studyCafePassOrder = StudyCafePassOrder.of(studyCafeSeatPass, studyCafeLockerPass);

        // then
        assertThat(studyCafePassOrder.getLockerPass()).isPresent();
        assertThat(studyCafePassOrder.getLockerPass().get()).isIn(studyCafeLockerPass);
    }

}
