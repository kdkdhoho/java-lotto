package lotto.domain.numbergenerator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class LottoNumberGenerator implements NumberGenerator {

    public int generate() {
        return Randoms.pickNumberInRange(Lotto.NUMBER_LOWER_BOUND, Lotto.NUMBER_UPPER_BOUND);
    }

}
