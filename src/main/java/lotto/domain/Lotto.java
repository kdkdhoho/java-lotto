package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final String ERROR_MESSAGE = "[ERROR] Lotto 생성 중 예외가 발생했습니다.";
    public static final int NUMBER_LOWER_BOUND = 1;
    public static final int NUMBER_UPPER_BOUND = 45;
    public static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        try {
            validateSize(numbers);
            validateRange(numbers);
            validateDuplicate(numbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateRange(number);
        }
    }

    private void validateRange(int number) {
        if (number < NUMBER_LOWER_BOUND || number > NUMBER_UPPER_BOUND) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> container = new HashSet<>();
        for (Integer number : numbers) {
            container.add(number);
        }

        if (container.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean validateDuplicate(int number) {
        return (numbers.contains(number));
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
