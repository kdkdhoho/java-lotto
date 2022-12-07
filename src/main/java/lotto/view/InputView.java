package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();

    public String readMoney() {
        System.out.println("구입금액을 입력해주세요.");
        String input = readLine();
        inputValidator.validateMoney(input);
        return input;
    }

    public String readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        inputValidator.validateWinningNumbers(input);
        return input;
    }

    public String readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = readLine();
        inputValidator.validateBonusNumber(input);
        return input;
    }
}
