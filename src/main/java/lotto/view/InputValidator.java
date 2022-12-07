package lotto.view;

public class InputValidator {
    public static final int MONEY_UNIT = 1_000;

    public void validateMoney(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
            validateAmount(money);
            validateUnit(money);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private void validateAmount(int money) {
        if (money < MONEY_UNIT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUnit(int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }
}
