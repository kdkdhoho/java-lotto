package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int SIZE = 6;

    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = generateLotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("로또 한 장은 숫자 6개 입니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> container = new HashSet<>(numbers);
        if (container.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 한 장에 숫자가 중복되면 안됩니다.");
        }
    }

    private List<Number> generateLotto(List<Integer> numbers) {
        return numbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbersToInt() {
        return Number.ofSortedList(this.numbers);
    }

    public boolean contains(Number number) {
        return this.numbers.stream()
                .anyMatch(number::equals);
    }

    public int compare(Lotto otherLotto) {
        Set<Integer> container = new HashSet<>(otherLotto.getNumbersToInt());

        for (Number number : this.numbers) {
            number.remove(container);
        }

        return Lotto.SIZE - container.size();
    }
}
