package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Manager;
import lotto.service.LottoService;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String ERROR_MONEY_AMOUNT = ERROR_PREFIX + " 금액은 1,000원 이상입니다.";
    public static final String ERROR_MONEY_UNIT = ERROR_PREFIX + " 금액은 1,000원 단위입니다.";
    public static final String ERROR_NUMBER_LENGTH = ERROR_PREFIX + " 당첨 번호는 6개 입니다.";
    public static final String ERROR_NOT_NUMERIC = ERROR_PREFIX + " 숫자를 입력해주세요.";
    public static final String ERROR_NUMBER_DUPLICATE = ERROR_PREFIX + " 당첨 번호는 중복될 수 없습니다.";
    public static final String ERROR_NUMBER_RANGE = ERROR_PREFIX + " 당첨 번호는 1부터 45 사이의 수 입니다.";

    public void validateMoney(String input) {
        int money;
        try {
            money = isNumeric(input);
            validateAmount(money);
            validateUnit(money);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private void validateAmount(int money) {
        if (money < Manager.LOTTO_AMOUNT_UNIT) {
            throw new IllegalArgumentException(ERROR_MONEY_AMOUNT);
        }
    }

    private void validateUnit(int money) {
        if (money % Manager.LOTTO_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_MONEY_UNIT);
        }
    }

    public void validateWinningNumbers(String input) {
        String[] numbers = input.split(LottoService.DELIMITER);
        trimNumbers(numbers);

        validateSize(numbers);
        validateNumber(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void trimNumbers(String[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i].trim();
        }
    }

    private void validateSize(String[] numbers) {
        if (numbers.length != Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_NUMBER_LENGTH);
        }
    }

    private void validateNumber(String[] numbers) {
        for (String number : numbers) {
            Integer.parseInt(number);
        }
    }

    private int isNumeric(String number) {
        try {
            return Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            e = new IllegalArgumentException(ERROR_NOT_NUMERIC);
            throw e;
        }
    }

    private void validateDuplicate(String[] numbers) {
        Set<String> container = new HashSet<>();
        for (String number : numbers) {
            container.add(number);
        }

        if (numbers.length != container.size()) {
            throw new IllegalArgumentException(ERROR_NUMBER_DUPLICATE);
        }
    }

    private void validateRange(String[] numbers) {
        for (String number : numbers) {
            validateRange(number);
        }
    }

    private void validateRange(String number) {
        int target = Integer.parseInt(number);
        if (target < Lotto.NUMBER_LOWER_BOUND || target > Lotto.NUMBER_UPPER_BOUND) {
            throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
        }
    }

    public void validateBonusNumber(String input) {
        validateRange(input);
        isNumeric(input);
    }
}
