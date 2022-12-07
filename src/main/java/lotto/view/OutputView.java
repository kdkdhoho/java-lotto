package lotto.view;

import lotto.domain.Rank;

import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.Arrays;

public class OutputView {

    public void printPurchase(List<List<Integer>> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (List<Integer> lotto : lottos) {
            System.out.println(join(lotto));
        }
    }

    private String join(List<Integer> lotto) {
        Collections.sort(lotto);

        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (Integer number : lotto) {
            stringJoiner.add(String.valueOf(number));
        }

        return stringJoiner.toString();
    }

    public void printWinResult(Map<Rank, Integer> ranks) {
        NumberFormat numberFormat = NumberFormat.getInstance();

        Rank[] values = Rank.values();
        Arrays.sort(values);
        for (Rank rank : values) {
            System.out.printf(String.format("%d개 일치 (%d원) - %d개\n"),
                    rank.getCorrectCount(), numberFormat.format(rank.getPrize()), ranks.get(rank));
        }
    }
}
