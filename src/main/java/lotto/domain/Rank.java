package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    int correctCount;
    boolean correctBonus;
    int prize;

    Rank(int correctCount, boolean correctBonus, int prize) {
        this.correctCount = correctCount;
        this.correctBonus = correctBonus;
        this.prize = prize;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public boolean isCorrectBonus() {
        return correctBonus;
    }

    public int getPrize() {
        return prize;
    }

    public Rank getRank(int correctCount, boolean correctBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> this.correctCount == correctCount && this.correctBonus == correctBonus)
                .findFirst()
                .orElse(NONE);
    }
}
