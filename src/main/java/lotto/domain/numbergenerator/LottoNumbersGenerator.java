package lotto.domain.numbergenerator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;

public class LottoNumbersGenerator implements NumberGenerator {

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(Lotto.NUMBER_LOWER_BOUND, Lotto.NUMBER_UPPER_BOUND, Lotto.SIZE);
    }

}
