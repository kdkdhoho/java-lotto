package lotto.util;

import lotto.domain.enums.Message;
import lotto.domain.enums.Number;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionHandler {

    public static final String NOT_NUMBER_REGEX = "\\D";
    public static final String COMMA = ",";

    public static void checkValidationMoney(String input) throws IllegalArgumentException {
        try {
            int inputNumber = Integer.parseInt(input);
            checkThousandUnit(inputNumber);
        } catch (IllegalArgumentException exception) {
            throw makeIllegalArgumentException(Message.NOT_THOUSAND_UNIT_INPUT_ERROR);
        }
    }

    private static void checkThousandUnit(int input) throws IllegalArgumentException {
        if (input % Number.THOUSAND.getValue() != Number.ZERO.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkValidationBonusNumber(String input, List<Integer> winningNumbers) throws IllegalArgumentException {
        Integer bonusNumber = Integer.parseInt(input);
        if (winningNumbers.contains(bonusNumber)) {
            throw makeIllegalArgumentException(Message.BONUS_NUMBER_INPUT_ERROR);
        }
    }

    public static void checkValidationWinningNumber(String input) throws IllegalArgumentException {
        try {
            isSixNumbers(input);
            isOnlyCommaAndNumber(input);
            isAllDifferentNumbers(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw makeIllegalArgumentException(Message.INPUT_WINNING_NUMBER_ERROR);
        }
    }

    private static void isSixNumbers(String input) throws IllegalArgumentException {
        String[] numbers = input.split(COMMA);
        if (numbers.length != Number.SIX.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private static void isOnlyCommaAndNumber(String input) throws IllegalArgumentException {
        String[] numbers = input.split(COMMA);
        Pattern pattern = Pattern.compile(NOT_NUMBER_REGEX);

        for (String number : numbers) {
            Matcher matcher = pattern.matcher(number);
            if (matcher.find()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void isAllDifferentNumbers(String input) throws IllegalArgumentException {
        String[] numbers = input.split(COMMA);
        List<String> container = new ArrayList<>();

        for (String number : numbers) {
            if (container.contains(number)) {
                throw new IllegalArgumentException();
            }

            container.add(number);
        }
    }

    public static IllegalArgumentException makeIllegalArgumentException(Message message) {
        return new IllegalArgumentException(message.getMessage());
    }
}
