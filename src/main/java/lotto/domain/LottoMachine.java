package lotto.domain;

import lotto.domain.numbergenerator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int UNIT = 1_000;

    private final NumberGenerator numberGenerator;

    public LottoMachine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lottos exchange(int purchaseMoney) {
        validate(purchaseMoney);
        List<Lotto> lottos = new ArrayList<>();

        while (purchaseMoney > 0) {
            lottos.add(generateLotto());
            purchaseMoney -= UNIT;
        }
        return new Lottos(lottos);
    }

    private void validate(int money) {
        isThousandUnit(money);
        isMoreThanThousand(money);
    }

    private void isThousandUnit(int money) {
        if (money % UNIT != 0) {
            throw new IllegalArgumentException(UNIT + "단위로 입력해주세요.");
        }
    }

    private void isMoreThanThousand(int money) {
        if (money < UNIT) {
            throw new IllegalArgumentException(UNIT + "이상으로 입력해주세요.");
        }
    }

    public Lotto generateLotto() {
        List<Integer> numbers = numberGenerator.generate();
        return new Lotto(numbers);
    }
}
