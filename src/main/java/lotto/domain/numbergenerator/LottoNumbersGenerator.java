package lotto.domain.numbergenerator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Number;

import java.util.List;

public class LottoNumbersGenerator implements NumberGenerator {

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(Number.NUMBER_LOWER_BOUND, Number.NUMBER_UPPER_BOUND, Lotto.SIZE);
    }

}
