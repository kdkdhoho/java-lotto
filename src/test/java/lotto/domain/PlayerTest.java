package lotto.domain;

import lotto.domain.numbergenerator.LottoNumbersGenerator;
import lotto.domain.numbergenerator.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class PlayerTest {
    private final NumberGenerator numberGenerator = new LottoNumbersGenerator();
    private final LottoMachine lottoMachine = new LottoMachine(numberGenerator);
    private final Manager manager = new Manager(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Number(7));

    @DisplayName("1,000원 단위가 아니거나 1,000원 미만인 값이 Player에 들어갈 때 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {-999, -1, 0, 1, 9, 99, 999, 1_001, 1_999})
    void Player_Exception(int money) {
        Lottos lottos = lottoMachine.exchange(new Money(3000));

        assertThatIllegalArgumentException().isThrownBy(() -> {
                new Player(lottos, money);
            });
    }

    @DisplayName("1,000원 단위가 들어갔을 때 정상적으로 Player 객체 생성")
    @ParameterizedTest
    @ValueSource(ints = {1_000, 2_000, 1_000_000})
    void Player(int money) {
        Lottos lottos = lottoMachine.exchange(new Money(3000));

        assertThatNoException().isThrownBy(() -> {
                new Player(lottos, money);
            });
    }
}