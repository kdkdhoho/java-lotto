package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class ManagerTest {
    private final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private final Number bonusNumber = new Number(7);

    @DisplayName("Manager 유효성 검사 - 당첨 번호와 보너스 번호가 중복")
    @Test
    void validate_Exception() {
        Number bonusNumber = new Number(6);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Manager(winningLotto, bonusNumber);
        });
    }

    @DisplayName("Manager 유효성 검사 - 성공")
    @Test
    void validate() {
        assertThatNoException().isThrownBy(() -> {
            new Manager(winningLotto, bonusNumber);
        });
    }

    @DisplayName("playerLotto와 비교하여 올바른 Rank 반환 테스트")
    @Test
    void compare() {
        Manager manager = new Manager(winningLotto, bonusNumber);
        Lotto playerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        Rank result = manager.compare(playerLotto);

        assertThat(result).isEqualTo(Rank.SECOND);
    }
}