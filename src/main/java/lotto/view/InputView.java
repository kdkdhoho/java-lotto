package lotto.view;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();

    public String readMoney() {
        String input = readLine();
        inputValidator.validateMoney(input);
        return input;
    }

    public String readWinningNumbers() {
        String input = readLine();
        inputValidator.validateWinningNumbers(input);
        return input;
    }

    public String readBonusNumber(List<Integer> winningLotto) {
        String input = readLine();
        inputValidator.validateBonusNumber(input, winningLotto);
        return input;
    }
}
