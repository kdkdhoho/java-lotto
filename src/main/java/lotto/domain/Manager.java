package lotto.domain;

import lotto.view.InputValidator;

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
            throw new IllegalArgumentException(InputValidator.ERROR_PREFIX + "당첨 번호와 보너스 번호가 중복되었습니다.");
        }
    }

    public int makeBonusNumber(LottoMachine lottoMachine) {
        return lottoMachine.generateBonusNumber(this.winningLotto);
    }

    public Rank compare(Lotto playerLotto) {
        int correctCount = winningLotto.compare(playerLotto);
        boolean correctBonus = winningLotto.contains(this.bonusNumber);

        return Rank.getRank(correctCount, correctBonus);
    }
}
