package lotto.controller;

import lotto.domain.Rank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        try {
            setPlayer();
            setManager();
            printTotalResult();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private void setPlayer() {
        int money = inputView.readMoney();
        lottoService.setPlayer(money);
        outputView.printPurchase(lottoService.getPlayerLottoNumbers());
    }

    private void setManager() {
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();
        lottoService.setManager(winningNumbers, bonusNumber);
    }

    private void printTotalResult() {
        Map<Rank, Integer> ranks = lottoService.getResult();
        int playerMoney = lottoService.getPlayerMoney();
        outputView.printTotalResult(ranks, playerMoney);
    }
}
