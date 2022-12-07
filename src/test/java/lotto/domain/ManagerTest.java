package lotto.domain;

import lotto.domain.numbergenerator.LottoNumberGenerator;
import lotto.domain.numbergenerator.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ManagerTest {
    private final Manager manager = new Manager();

    @DisplayName("구입 금액에 해당하는만큼 로또 발행")
    @Test
    void exchange() {
        NumberGenerator numberGenerator = new LottoNumberGenerator();
        LottoMachine lottoMachine = new LottoMachine(numberGenerator);
        int money = 3000;

        Lottos lottos = manager.exchange(lottoMachine, money);
        assertThat(lottos).extracting("lottos")
                .extracting("size")
                .isEqualTo(3);
    }

    @DisplayName("구입 금액에 해당하는만큼 로또 발행 금액과 장수 다르게 테스트")
    @Test
    void exchange_fail() {
        NumberGenerator numberGenerator = new LottoNumberGenerator();
        LottoMachine lottoMachine = new LottoMachine(numberGenerator);
        int money = 4000;

        Lottos lottos = manager.exchange(lottoMachine, money);
        assertThat(lottos).extracting("lottos")
                .extracting("size")
                .isNotEqualTo(3);
    }
}