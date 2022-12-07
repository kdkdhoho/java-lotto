package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    public static final int LOTTO_AMOUNT_UNIT = 1000;

    public Lottos exchange(LottoMachine lottoMachine, int money) {
        List<Lotto> lottos = new ArrayList<>();

        while (money > 0) {
            lottos.add(lottoMachine.generateLotto());
            money -= LOTTO_AMOUNT_UNIT;
        }

        return new Lottos(lottos);
    }
}
