package lotto.domain;

import lotto.domain.numbergenerator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final NumberGenerator numberGenerator;

    public LottoMachine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lottos exchange(Money purchaseMoney) {
        List<Lotto> lottos = new ArrayList<>();

        while (purchaseMoney.isBiggerOrEqualThanUnit()) {
            lottos.add(generateLotto());
            purchaseMoney.subUnit();
        }
        return new Lottos(lottos);
    }

    public Lotto generateLotto() {
        List<Integer> numbers = numberGenerator.generate();
        return new Lotto(numbers);
    }
}
