package lotto.domain;

import lotto.domain.numbergenerator.NumberGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LottoMachine {

    public Lotto generateLotto(NumberGenerator numberGenerator) {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < Lotto.LOTTO_SIZE) {
            numbers.add(numberGenerator.generate());
        }
        return new Lotto(new ArrayList<>(numbers));
    }
}
