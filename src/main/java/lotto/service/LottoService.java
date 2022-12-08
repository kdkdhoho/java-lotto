package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Manager;
import lotto.domain.Player;
import lotto.domain.Rank;
import lotto.domain.numbergenerator.LottoNumbersGenerator;
import lotto.domain.numbergenerator.NumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {
    public static final String DELIMITER = ",";

    private final NumberGenerator numberGenerator = new LottoNumbersGenerator();
    private final LottoMachine lottoMachine = new LottoMachine(numberGenerator);
    private Player player;
    private Manager manager;

    public void setPlayer(String input) {
        int money = Integer.parseInt(input);
        Lottos lottos = lottoMachine.exchange(money);
        player = new Player(lottos, money);
    }

    public List<List<Integer>> getPlayerLottoNumbers() {
        return player.getLottoNumbers();
    }

    public void setManager(String winningNumbersInput, String bonusNubmer) {
        List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Lotto winningLotto = new Lotto(winningNumbers);
        BonusNumber bonusNumberResult = new BonusNumber(Integer.parseInt(bonusNubmer));

        manager = new Manager(winningLotto, bonusNumberResult);
    }

    public Map<Rank, Integer> getResult() {
        Map<Rank, Integer> result = player.getResult(manager);
        return result;
    }

    public int getPlayerMoney() {
        return player.getMoney();
    }
}
