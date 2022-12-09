package lotto.view;

import lotto.domain.Rank;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

public class OutputView {
    public static final int PERCENTAGE = 100;
    public static final String DELIMITER = ", ";
    public static final String PREFIX = "[";
    public static final String SUFFIX = "]";

    public void printPurchase(List<List<Integer>> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (List<Integer> lotto : lottos) {
            System.out.println(join(lotto));
        }
    }

    private String join(List<Integer> numbers) {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
        for (Integer number : numbers) {
            stringJoiner.add(String.valueOf(number));
        }

        return stringJoiner.toString();
    }

    public void printTotalResult(Map<Rank, Integer> ranks, int money) {
        System.out.println("\n당첨 통계\n---");
        printOverview(ranks);
        printRateOfReturn(ranks, money);
    }

    private void printOverview(Map<Rank, Integer> ranks) {
        System.out.printf("%d개 일치 (%,d원) - %d개\n", Rank.FIFTH.getCorrectCount(), Rank.FIFTH.getPrize(), ranks.getOrDefault(Rank.FIFTH, 0));
        System.out.printf("%d개 일치 (%,d원) - %d개\n", Rank.FOURTH.getCorrectCount(), Rank.FOURTH.getPrize(), ranks.getOrDefault(Rank.FOURTH, 0));
        System.out.printf("%d개 일치 (%,d원) - %d개\n", Rank.THIRD.getCorrectCount(), Rank.THIRD.getPrize(), ranks.getOrDefault(Rank.THIRD, 0));
        System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", Rank.SECOND.getCorrectCount(), Rank.SECOND.getPrize(), ranks.getOrDefault(Rank.SECOND, 0));
        System.out.printf("%d개 일치 (%,d원) - %d개\n", Rank.FIRST.getCorrectCount(), Rank.FIRST.getPrize(), ranks.getOrDefault(Rank.FIRST, 0));
    }

    private void printRateOfReturn(Map<Rank, Integer> ranks, int money) {
        Long totalPrize = totalPrize(ranks);
        double rateOfReturn = calculateRateOfReturn(totalPrize, money);
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", rateOfReturn));
    }

    private Long totalPrize(Map<Rank, Integer> ranks) {
        Long result = 0L;

        Set<Rank> keys = ranks.keySet();
        for (Rank rank : keys) {
            int prize = rank.getPrize();
            result += prize * ranks.get(rank);
        }
        return result;
    }

    private double calculateRateOfReturn(Long totalPrize, int money) {
        return ((double)totalPrize / money) * PERCENTAGE;
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
