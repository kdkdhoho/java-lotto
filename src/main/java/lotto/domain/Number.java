package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Number {
    public static final int NUMBER_LOWER_BOUND = 1;
    public static final int NUMBER_UPPER_BOUND = 45;

    private final int number;

    public Number(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < NUMBER_LOWER_BOUND || number > NUMBER_UPPER_BOUND) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 수 입니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    public static List<Integer> ofSortedList(List<Number> numbers) {
        return numbers.stream()
                .map(Number::getNumber)
                .sorted()
                .collect(Collectors.toList());
    }

    public Set<Integer> remove(Set<Integer> container) {
        container.remove(this.number);
        return container;
    }
}
