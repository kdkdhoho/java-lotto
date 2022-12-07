package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();

    public String readMoney() {
        String input = readLine();
        inputValidator.validateMoney(input);
        return input;
    }
}
