package lotto.domain;

import lotto.domain.numbergenerator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final NumberGenerator numberGenerator;

    public LottoMachine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lottos exchange(int money) {
        List<Lotto> lottos = new ArrayList<>();

        while (money > 0) {
            lottos.add(generateLotto());
            money -= Manager.LOTTO_AMOUNT_UNIT;
        }
        return new Lottos(lottos);
    }

    public Lotto generateLotto() {
        List<Integer> numbers = numberGenerator.generate();
        return new Lotto(numbers);
    }

    public int generateBonusNumber(Lotto winningLotto) {
        List<Integer> numbers = numberGenerator.generate();
        int bonusNumber = numbers.get(0);
        if (winningLotto.validateDuplicate(bonusNumber)) {
            return generateBonusNumber(winningLotto);
        }
        return bonusNumber;
    }
}
