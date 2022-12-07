package lotto.domain;

import lotto.domain.numbergenerator.NumberGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LottoMachine {
    private final NumberGenerator numberGenerator;

    public LottoMachine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lotto generateLotto() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < Lotto.LOTTO_SIZE) {
            numbers.add(numberGenerator.generate());
        }
        return new Lotto(new ArrayList<>(numbers));
    }

    public int generateBonusNumber(Lotto winningLotto) {
        int bonusNumber = numberGenerator.generate();
        if (winningLotto.validateDuplicate(bonusNumber)) {
            return generateBonusNumber(winningLotto);
        }
        return bonusNumber;
    }
}
