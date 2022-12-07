package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<List<Integer>> getLottoNumbers() {
        return lottos.getLottoNumbers();
    }

    public Map<Rank, Integer> getResult(Manager manager) {
        Map<Rank, Integer> ranks = new HashMap<>();

        List<Lotto> lottos = this.lottos.getLottos();
        for (Lotto lotto : lottos) {
            Rank rank = manager.compare(lotto);
            ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
        }
        return ranks;
    }

    public int getMoney() {
        return money;
    }
}
