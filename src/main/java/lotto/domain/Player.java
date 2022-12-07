package lotto.domain;

public class Player {
    private final Lottos lottos;
    private final int money;

    public Player(Lottos lottos, int money) {
        validate(money);
        this.lottos = lottos;
        this.money = money;
    }

    private void validate(int money) {
        validateUnit(money);
        validateAmount(money);
    }

    private void validateUnit(int money) {
        if (money % Manager.LOTTO_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateAmount(int money) {
        if (money < Manager.LOTTO_AMOUNT_UNIT) {
            throw new IllegalArgumentException();
        }
    }
}
