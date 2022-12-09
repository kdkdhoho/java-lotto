package lotto.service;

import lotto.domain.Money;
import lotto.domain.Number;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Manager;
import lotto.domain.Player;
import lotto.domain.Rank;
import lotto.domain.numbergenerator.LottoNumbersGenerator;
import lotto.domain.numbergenerator.NumberGenerator;

import java.util.List;
import java.util.Map;

public class LottoService {
    private final NumberGenerator numberGenerator = new LottoNumbersGenerator();
    private final LottoMachine lottoMachine = new LottoMachine(numberGenerator);
    private Player player;
    private Manager manager;

    public void setPlayer(int purchaseMoney) {
        Lottos purchasedLottos = lottoMachine.exchange(new Money(purchaseMoney));
        player = new Player(purchasedLottos, purchaseMoney);
    }

    public List<List<Integer>> getPlayerLottoNumbers() {
        return player.getLottoNumbers();
    }

    public void setManager(List<Integer> winningNumbers, int bonusNumber) {
        Lotto winningLotto = new Lotto(winningNumbers);
        Number numberResult = new Number(bonusNumber);

        manager = new Manager(winningLotto, numberResult);
    }

    public Map<Rank, Integer> getResult() {
        Map<Rank, Integer> result = player.getResult(manager);
        return result;
    }

    public int getPlayerMoney() {
        return player.getMoney();
    }
}
