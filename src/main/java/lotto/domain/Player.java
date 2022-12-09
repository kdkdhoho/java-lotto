package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Player {
    private final Lottos lottos;
    private final Money money;

    public Player(Lottos lottos, Money money) {
        this.lottos = lottos;
        this.money = money;
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottos.getLottoNumbers();
    }

    public Map<Rank, Integer> getResult(Manager manager) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);

        List<Lotto> lottos = this.lottos.getLottos();
        for (Lotto lotto : lottos) {
            Rank rank = manager.compare(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    public int getMoney() {
        return money.getMoney();
    }
}
