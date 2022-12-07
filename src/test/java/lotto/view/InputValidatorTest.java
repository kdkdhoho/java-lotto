package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("1,000원 단위가 아니고 1,000원 미만의 값이 입력되면 IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings = {"-999", "-100", "-0", "0", "1", "99", "999", "1001", "1999"})
    void validateMoney_Exception(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputValidator.validateMoney(input);
        });
    }

    @DisplayName("1,000원 이상이며 1,000원 단위의 값이 입력된 경우")
    @Test
    void validateMoney() {
        String input = "1000";
        assertThatNoException().isThrownBy(() -> {
            inputValidator.validateMoney(input);
        });
    }

    @DisplayName("당첨 번호로 중복, 1~45 범위 외, 문자, 6자리가 아닌 입력이 들어온 경우 IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,4,5,46", "1,a,b,3,d,g", "1,2,3,4,5,6,7"})
    void validateWinningNumbers_Exception(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputValidator.validateWinningNumbers(input);
        });
    }

    @DisplayName("당첨 번호로 올바른 값이 들어간 경우")
    @Test
    void validateWinningNumbers() {
        String input = "1, 2, 3, 4, 5, 6";
        assertThatNoException().isThrownBy(() -> {
            inputValidator.validateWinningNumbers(input);
        });
    }

    @DisplayName("보너스 번호로 1~45 범위 외, 문자 입력이 들어온 경우 IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "a", "", " "})
    void validateBonusNumber_Exception(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputValidator.validateBonusNumber(input);
        });
    }

    @DisplayName("보너스 번호로 적절한 값이 들어간 경우")
    @Test
    void validateBonusNumber() {
        String input = "7";

        assertThatNoException().isThrownBy(() -> {
            inputValidator.validateBonusNumber(input);
        });
    }
}