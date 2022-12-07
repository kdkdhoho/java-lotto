package lotto.domain.numbergenerator;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Manager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class PlayerTest {
    private final Manager manager = new Manager();
    private final NumberGenerator numberGenerator = new LottoNumberGenerator();
    private final LottoMachine lottoMachine = new LottoMachine(numberGenerator);

    @DisplayName("1,000원 단위가 아닌 값이 Player에 들어갈 때 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {1, 9, 99, 999, 1_001, 1_999})
    void Player_Exception(int money) {
        Lottos lottos = manager.exchange(lottoMachine, 3000);

        assertThatIllegalArgumentException().isThrownBy(() -> {
                new Player(lottos, money);
            });
    }

    @DisplayName("1,000원 단위가 들어갔을 때 정상적으로 Player 객체 생성")
    @ParameterizedTest
    @ValueSource(ints = {1_000, 2_000, 1_000_000})
    void Player(int money) {
        Lottos lottos = manager.exchange(lottoMachine, 3000);

        assertThatNoException().isThrownBy(() -> {
                new Player(lottos, money);
            });
    }
}