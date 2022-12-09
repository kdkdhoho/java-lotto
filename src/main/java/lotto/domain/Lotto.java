package lotto.domain;

import java.util.Collections;
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

    public List<Number> getNumbers() {
        List<Number> result = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        return Collections.unmodifiableList(result);
    }

    public boolean contains(Number number) {
        return numbers.contains(number.getNumber());
    }

    public int compare(Lotto otherLotto) {
        List<Number> otherLottoNumbers = otherLotto.getNumbers();
        Set<Number> container = new HashSet<>(otherLottoNumbers);

        for (Number number : this.numbers) {
            container.remove(number);
        }

        return Lotto.SIZE - container.size();
    }
}
