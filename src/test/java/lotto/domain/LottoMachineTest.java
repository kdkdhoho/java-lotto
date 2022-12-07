package lotto.domain;

import lotto.domain.numbergenerator.LottoNumberGenerator;
import lotto.domain.numbergenerator.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("보너스 넘버를 뽑았을 때 우승 번호에 중복되지 않는 번호를 뽑아야 한다")
    @Test
    void generateBonusNumber() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int result = lottoMachine.generateBonusNumber(winningLotto);

        assertThat(result).isNotIn(winningLotto);
    }

}