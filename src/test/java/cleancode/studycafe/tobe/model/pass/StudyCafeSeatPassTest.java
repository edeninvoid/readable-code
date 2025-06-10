package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static cleancode.studycafe.tobe.model.pass.StudyCafePassType.HOURLY;
import static org.assertj.core.api.Assertions.assertThat;

class StudyCafeSeatPassTest {

    @DisplayName("스터디 카페 좌석의 유형을 확인한다.")
    @Test
    void getPassType() {
        // given
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(HOURLY, 12, 13000, 0.0);

        // when

        // then
        assertThat(studyCafeSeatPass.getPassType()).isEqualTo(HOURLY);
    }

    @DisplayName("스터디 카페 좌석의 가격을 확인한다.")
    @Test
    void getPrice() {
        // given
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(HOURLY, 12, 13000, 0.0);

        // when

        // then
        assertThat(studyCafeSeatPass.getPrice()).isEqualTo(13000);
    }

    @DisplayName("스터디 카페 좌석의 가격을 확인한다.")
    @Test
    void getDuration() {
        // given
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(HOURLY, 12, 13000, 0.0);

        // when

        // then
        assertThat(studyCafeSeatPass.getDuration()).isEqualTo(12);
    }

    @DisplayName("스터디 카페 좌석의 가격을 확인한다.")
    @Test
    void getDiscountPrice() {
        // given
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(HOURLY, 12, 13000, 0.0);

        // when

        // then
        assertThat(studyCafeSeatPass.getDiscountPrice()).isZero();
    }

}
