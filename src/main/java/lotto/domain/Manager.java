package lotto.domain;

import lotto.view.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    public static final int LOTTO_AMOUNT_UNIT = 1000;

    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public Manager(Lotto winningLotto, BonusNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, BonusNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(InputValidator.ERROR_PREFIX + " 당첨 번호와 보너스 번호가 중복되었습니다.");
        }
    }

    public Lottos exchange(LottoMachine lottoMachine, int money) {
        List<Lotto> lottos = new ArrayList<>();

        while (money > 0) {
            lottos.add(lottoMachine.generateLotto());
            money -= LOTTO_AMOUNT_UNIT;
        }

        return new Lottos(lottos);
    }

    public int makeBonusNumber(LottoMachine lottoMachine) {
        return lottoMachine.generateBonusNumber(this.winningLotto);
    }
}
