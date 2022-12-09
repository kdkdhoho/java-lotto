package lotto.domain;

public class Manager {
    private final Lotto winningLotto;
    private final Number number;

    public Manager(Lotto winningLotto, Number number) {
        validate(winningLotto, number);
        this.winningLotto = winningLotto;
        this.number = number;
    }

    private void validate(Lotto winningLotto, Number number) {
        if (winningLotto.contains(number)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복일 수 없습니다.");
        }
    }

    public Rank compare(Lotto playerLotto) {
        int correctCount = this.winningLotto.compare(playerLotto);
        boolean correctBonus = this.winningLotto.contains(this.number);

        return Rank.getRank(correctCount, correctBonus);
    }
}
