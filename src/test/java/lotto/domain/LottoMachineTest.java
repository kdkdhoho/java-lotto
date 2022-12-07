package lotto.domain;

import lotto.domain.numbergenerator.LottoNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("LottoMachine을 통해 만들어진 Lotto는 lotto.validate를 통과해야한다.")
    @Test
    void generateLottoTest() {
        Assertions.assertThatNoException()
                .isThrownBy(() -> {
                    lottoMachine.generateLotto(new LottoNumberGenerator());
                });
    }
}