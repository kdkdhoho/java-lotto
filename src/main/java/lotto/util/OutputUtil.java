package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.enums.Message;
import lotto.domain.enums.Number;

import java.util.List;
import java.util.Map;

public class OutputUtil {

    public static void printInputPurchaseAmount() {
        System.out.println(Message.INPUT_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public static void printInputPurchaseAmountError() {
        System.out.println(Message.NOT_THOUSAND_UNIT_INPUT_ERROR);
    }

    public static void printUserLottoCount(User user) {
        System.out.println("" + user.getLottoCount() + "개를 구매했습니다.");
    }

    public static void printUserLottos(User user) {
        for (Lotto lotto : user.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void printInputWinningNumbers() {
        System.out.println(Message.INPUT_WINNING_NUMBERS_MESSAGE.getMessage());
    }

    public static void printInputWinningNumbersError() {
        System.out.println(Message.INPUT_WINNING_NUMBER_ERROR);
    }

    public static void printInputBonusNumber() {
        System.out.println(Message.INPUT_BONUS_NUMBER_MESSAGE.getMessage());
    }

    public static void printInputBonusNumberError() {
        System.out.println(Message.BONUS_NUMBER_INPUT_ERROR);
    }

    public static void printResult(Map<Number, Integer> ranks) {
        System.out.println(Message.TOTAL_RESULT_MESSAGE);
        System.out.println(Message.RESULT_FIFTH.getMessage() + ranks.get(Number.FIVE) + "개");
        System.out.println(Message.RESULT_FOURTH.getMessage() + ranks.get(Number.FOUR) + "개");
        System.out.println(Message.RESULT_THIRD.getMessage() + ranks.get(Number.THREE) + "개");
        System.out.println(Message.RESULT_SECOND.getMessage() + ranks.get(Number.TWO) + "개");
        System.out.println(Message.RESULT_FIRST.getMessage() + ranks.get(Number.ONE) + "개");
    }

    public static void printYield(double yield) {
        System.out.printf(Message.YIELD_MESSAGE.getMessage(), yield);
    }
}
