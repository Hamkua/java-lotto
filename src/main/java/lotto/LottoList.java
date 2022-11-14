package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoList {
    private static int LOTTO_COUNT = 6;

    private static List<Lotto> lottos = new ArrayList<>();

    public LottoList(int lottoLength){
        for(int i = 0; i < lottoLength; i++){
            addLotto(LOTTO_COUNT);
        }
    }

    public static void addLotto(int count){
        Lotto lotto = new Lotto(pickUniqueNumbersInRange(1, 45, count));
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
