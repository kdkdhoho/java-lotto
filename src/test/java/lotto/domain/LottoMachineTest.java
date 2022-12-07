package lotto.domain;

import lotto.domain.numbergenerator.LottoNumberGenerator;
import lotto.domain.numbergenerator.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoMachineTest {
    private final NumberGenerator numberGenerator = new LottoNumberGenerator();
    private final LottoMachine lottoMachine = new LottoMachine(numberGenerator);

    @DisplayName("LottoMachine을 통해 만들어진 Lotto는 lotto.validate를 통과해야한다.")
    @Test
    void generateLotto() {
        assertThatNoException()
                .isThrownBy(() -> {
                    lottoMachine.generateLotto();
                });
    }

    @DisplayName("구입 금액에 해당하는만큼 로또 발행")
    @Test
    void exchange() {
        int money = 3000;

        Lottos lottos = lottoMachine.exchange(money);
        assertThat(lottos).extracting("lottos")
                .extracting("size")
                .isEqualTo(3);
    }

    @DisplayName("구입 금액에 해당하는만큼 로또 발행 금액과 장수 다르게 테스트")
    @Test
    void exchange_Exception() {
        int money = 4000;

        Lottos lottos = lottoMachine.exchange(money);
        assertThat(lottos).extracting("lottos")
                .extracting("size")
                .isNotEqualTo(3);
    }
}