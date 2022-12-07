package lotto.domain;

import lotto.domain.numbergenerator.LottoNumberGenerator;
import lotto.domain.numbergenerator.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}