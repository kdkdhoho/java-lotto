package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class BonusNumberTest {

    @DisplayName("범위 밖의 번호로 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-10, -9, -1, 0, 46, 49})
    void getBonusNumber_Exception(int bonusNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BonusNumber(bonusNumber);
        });
    }

    @DisplayName("범위 내의 번호로 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 21, 44, 45})
    void getBonusNumber(int bonusNumber) {
        assertThatNoException().isThrownBy(() -> {
            new BonusNumber(bonusNumber);
        });
    }
}