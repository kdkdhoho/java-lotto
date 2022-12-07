package lotto.domain.numbergenerator;

import lotto.domain.Lottos;
import lotto.domain.Manager;

public class Player {
    private final Lottos lottos;
    private final int money;

    public Player(Lottos lottos, int money) {
        validate(money);
        this.lottos = lottos;
        this.money = money;
    }

    private void validate(int money) {
        if (money % Manager.LOTTO_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }
}
