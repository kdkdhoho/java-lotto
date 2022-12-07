package lotto.domain;

import lotto.view.InputValidator;

public class BonusNumber {
    public static final String ERROR_MESSAGE = InputValidator.ERROR_PREFIX + " BonusNumber 생성 중 예외가 발생했습니다.";

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        try {
            validateRange(bonusNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void validateRange(int number) {
        if (number < Lotto.NUMBER_LOWER_BOUND || number > Lotto.NUMBER_UPPER_BOUND) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
