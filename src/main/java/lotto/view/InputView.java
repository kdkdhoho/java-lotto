package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String DELIMITER_COMMA = ",";

    public int readMoney() {
        System.out.println("구입금액을 입력해주세요.");
        String input = readLine();
        int money = toInt(input);
        return money;
    }

    public List<Integer> readWinningNumbers() {
        System.out.println(System.lineSeparator() + "당첨 번호를 입력해 주세요.");
        String input = readLine();
        return toList(input);
    }

    public int readBonusNumber() {
        System.out.println(System.lineSeparator() + "보너스 번호를 입력해 주세요.");
        String input = readLine();
        return toInt(input);
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요.");
        }
    }

    private List<Integer> toList(String input) {
        String[] numbers = input.split(DELIMITER_COMMA);

        return Arrays.stream(numbers)
                .map(String::trim)
                .map(this::toInt)
                .collect(Collectors.toList());
    }
}
