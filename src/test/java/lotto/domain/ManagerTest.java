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
    private final Manager manager = new Manager(winningLotto);

    @DisplayName("구입 금액에 해당하는만큼 로또 발행")
    @Test
    void exchange() {
        int money = 3000;

        Lottos lottos = manager.exchange(lottoMachine, money);
        assertThat(lottos).extracting("lottos")
                .extracting("size")
                .isEqualTo(3);
    }

    @DisplayName("구입 금액에 해당하는만큼 로또 발행 금액과 장수 다르게 테스트")
    @Test
    void exchange_Exception() {
        int money = 4000;

        Lottos lottos = manager.exchange(lottoMachine, money);
        assertThat(lottos).extracting("lottos")
                .extracting("size")
                .isNotEqualTo(3);
    }

    @DisplayName("winningNumber와 중복되지 않는 bonusNumber 만들어내기")
    @Test
    void makeBonusNumber() {
        int bonusNumber = manager.makeBonusNumber(lottoMachine);

        assertThat(bonusNumber).isNotIn(winningLotto);
    }
}