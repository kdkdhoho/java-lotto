package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<List<Integer>> getLottoNumbers() {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    //    public void getResult(Manager manager) {
//
//    }
}
