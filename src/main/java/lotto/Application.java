package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Iterator;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요.");
        int amount = UserInput.purchaseAmountInput();

        System.out.println(amount + "개를 구매했습니다.");
        LottoList lottoFactory = new LottoList(amount);
        List<Lotto> lottos = lottoFactory.getLottos();

        for(Lotto lotto : lottos){
            System.out.println(lotto);
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> userWinningNumber = UserInput.winningNumbersInput();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = UserInput.bonusNumberInput();


        int[] scores = new int[6];
        int[] bonuses = new int[6];

        for(int i = 0; i < 6; i ++){
            Lotto lotto = lottos.get(i);

            List<Integer> numbers = lotto.getNumbers();

            int score = 0;
            int bonusScore = 0;
            for(int j = 0; j < 6; j++){
                if(numbers.contains(userWinningNumber.get(j))){
                    System.out.println(numbers + " , " + userWinningNumber.get(j));
                    score++;
                }

                if(numbers.contains(bonus)){
                    System.out.println(numbers + " , bonus " + bonus);
                    bonusScore++;
                }
            }
            scores[i] = score;
            bonuses[i] = bonusScore;
            System.out.println();
        }

        for(int i = 0; i< 6; i++) {
            System.out.println("score = " + scores[i] + ", bonusCnt = " + bonuses[i]);
        }

    }

}
