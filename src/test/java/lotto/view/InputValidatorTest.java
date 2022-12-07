package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("1,000원 단위가 아니고 1,000원 미만의 값이 입력되면 IllegalArgumentException을 던진다")
    @ParameterizedTest
    @ValueSource(strings = {"-999", "-100", "-0", "0", "1", "99", "999", "1001", "1999"})
    void validateMoney_Exception(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputValidator.validateMoney(input);
        });
    }
}