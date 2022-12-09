package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Manager;
import lotto.domain.Money;
import lotto.domain.Number;
import lotto.domain.Player;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class LottoService {
    private final LottoMachine lottoMachine = new LottoMachine();
    private Player player;
    private Manager manager;

    public void setPlayer(int purchaseMoney) {
        Lottos purchasedLottos = lottoMachine.exchange(new Money(purchaseMoney));
        player = new Player(purchasedLottos, new Money(purchaseMoney));
    }

    public List<List<Integer>> getPlayerLottoNumbers() {
        return player.getLottoNumbers();
    }

    public Lotto generateWinningLotto(List<Integer> winningNumbers) {
        return new Lotto(winningNumbers);
    }

    public Number generateBonusNumber(int bonusNumber) {
        return new Number(bonusNumber);
    }

    public void setManager(Lotto winningLotto, Number bonusNumber) {
        manager = new Manager(winningLotto, bonusNumber);
    }

    public Map<Rank, Integer> getResult() {
        return player.getResult(manager);
    }

    public int getPlayerMoney() {
        return player.getMoney();
    }
}
