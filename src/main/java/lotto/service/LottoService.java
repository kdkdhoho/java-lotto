package lotto.service;

import lotto.domain.*;
import lotto.domain.numbergenerator.LottoNumberGenerator;
import lotto.domain.numbergenerator.NumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    public static final String DELIMITER = ",";

    private final NumberGenerator numberGenerator = new LottoNumberGenerator();
    private final LottoMachine lottoMachine = new LottoMachine(numberGenerator);

    private Player player;
    private Manager manager;

    public void setPlayer(String input) {
        int money = Integer.parseInt(input);
        Lottos lottos = manager.exchange(lottoMachine, money);
        player = new Player(lottos, money);
    }

    public List<List<Integer>> getPlayerLottoNumbers() {
        return player.getLottoNumbers();
    }

    public void makeWinningLotto(String input) {
        List<Integer> winningNumbers = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        manager = new Manager(new Lotto(winningNumbers));
    }
}
