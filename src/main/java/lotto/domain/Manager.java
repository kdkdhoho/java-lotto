package lotto.domain;

public class Manager {
    private final Lotto winningLotto;
    private final Number bonusNumber;

    public Manager(Lotto winningLotto, Number bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, Number bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복일 수 없습니다.");
        }
    }

    public Rank compare(Lotto playerLotto) {
        int correctCount = this.winningLotto.compare(playerLotto);
        boolean correctBonus = playerLotto.contains(this.bonusNumber);

        return Rank.getRank(correctCount, correctBonus);
    }
}
