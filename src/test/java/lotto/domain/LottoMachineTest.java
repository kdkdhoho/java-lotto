package lotto.domain;

import lotto.domain.numbergenerator.LottoNumbersGenerator;
import lotto.domain.numbergenerator.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoMachineTest {
    private final NumberGenerator numberGenerator = new LottoNumbersGenerator();
    private final LottoMachine lottoMachine = new LottoMachine(numberGenerator);
    private final Money money = new Money(3000);

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
        Lottos lottos = lottoMachine.exchange(money);
        List<Lotto> result = lottos.getLottos();
        assertThat(result.size()).isEqualTo(3);
    }

    @DisplayName("구입 금액에 해당하는만큼 로또 발행 금액과 장수 다르게 테스트")
    @Test
    void exchange_Exception() {
        Lottos lottos = lottoMachine.exchange(money);
        List<Lotto> result = lottos.getLottos();
        assertThat(result.size()).isNotEqualTo(4);
    }
}