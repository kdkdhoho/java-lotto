package lotto.domain;

import lotto.domain.numbergenerator.LottoNumberGenerator;
import lotto.domain.numbergenerator.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManagerTest {
    private final NumberGenerator numberGenerator = new LottoNumberGenerator();
    private final LottoMachine lottoMachine = new LottoMachine(numberGenerator);
    private final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private final BonusNumber bonusNumber = new BonusNumber(7);
    private final Manager manager = new Manager(winningLotto, bonusNumber);

    @DisplayName("winningNumber와 중복되지 않는 bonusNumber 만들어내기")
    @Test
    void makeBonusNumber() {
        int bonusNumber = manager.makeBonusNumber(lottoMachine);

        assertThat(bonusNumber).isNotIn(winningLotto);
    }
}