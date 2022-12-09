package lotto.domain;

public class Money {
    public static final int UNIT = 1_000;

    private int money;

    public Money(int money) {
        validate(money);
        this.money = money;
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

    public boolean isBiggerOrEqualThanUnit() {
        return money >= UNIT;
    }

    public void subUnit() {
        this.money -= UNIT;
    }

    public int getMoney() {
        return this.money;
    }
}
