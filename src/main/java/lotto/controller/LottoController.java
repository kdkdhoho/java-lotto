package lotto.controller;

import lotto.domain.Rank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        setPlayer();
        setManager();
        printTotalResult();
    }

    private void setPlayer() {
        String money = inputView.readMoney();
        lottoService.setPlayer(money);
        outputView.printPurchase(lottoService.getPlayerLottoNumbers());
    }

    private void setManager() {
        String winningNumbers = inputView.readWinningNumbers();
        String bonusNumber = inputView.readBonusNumber();
        lottoService.setManager(winningNumbers, bonusNumber);
    }

    private void printTotalResult() {
        Map<Rank, Integer> ranks = lottoService.getResult();
        int playerMoney = lottoService.getPlayerMoney();
        outputView.printTotalResult(ranks, playerMoney);
    }
}
