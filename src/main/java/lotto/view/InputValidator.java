package lotto.view;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static final int MONEY_UNIT = 1_000;
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_NUMBER_LOWER_BOUND = 1;
    public static final int LOTTO_NUMBER_UPPER_BOUND = 45;
    public static final String DELIMITER = ",";

    public void validateMoney(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
            validateAmount(money);
            validateUnit(money);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private void validateAmount(int money) {
        if (money < MONEY_UNIT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUnit(int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void validateWinningNumbers(String input) {
        String[] numbers = input.split(DELIMITER);
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
        if (numbers.length != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumber(String[] numbers) {
        for (String number : numbers) {
            Integer.parseInt(number);
        }
    }

    private void validateDuplicate(String[] numbers) {
        Set<String> container = new HashSet<>();
        for (String number : numbers) {
            container.add(number);
        }

        if (numbers.length != container.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(String[] numbers) {
        for (String number : numbers) {
            validateRange(number);
        }
    }

    private void validateRange(String number) {
        int target = Integer.parseInt(number);
        if (target < LOTTO_NUMBER_LOWER_BOUND || target > LOTTO_NUMBER_UPPER_BOUND) {
            throw new IllegalArgumentException();
        }
    }
}
