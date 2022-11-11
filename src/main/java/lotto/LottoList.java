package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoList {
    private static int COUNT = 6;

    private static List<Lotto> lottos = new ArrayList<>();

    public LottoList(int lottoAmount){
        for(int i = 0; i < lottoAmount; i++){
            addLotto(COUNT);
        }
    }

    public static void addLotto(int count){
        Lotto lotto = new Lotto(pickUniqueNumbersInRange(1, 45, count));
        lottos.add(lotto);
    }
}
