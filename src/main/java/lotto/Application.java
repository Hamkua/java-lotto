package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Iterator;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {
    public static final int UNIT = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int number = recieveAmount();

        System.out.println(number + "개를 구매했습니다.");
        LottoList lottoFactory = new LottoList(number);
        List<Lotto> lottos = lottoFactory.getLottos();

        for(Lotto lotto : lottos){
            System.out.println(lotto);
        }

        System.out.println("당첨 번호를 입력해 주세요.");

        String input = Console.readLine();
        String[] splittedString = input.split(",");
        for (String s:
             splittedString) {
            System.out.println(s);
        }
        System.out.println(splittedString.length);

        int[] splittedInput = new int[6];
        for(int i = 0; i < 6; i++){
            splittedInput[i] = Integer.parseInt(splittedString[i]);
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());



        int[] scores = new int[6];
        int[] bonuses = new int[6];

        for(int i = 0; i < 6; i ++){
            Lotto lotto = lottos.get(i);

            List<Integer> numbers = lotto.getNumbers();

            int score = 0;
            int bonusScore = 0;
            for(int j = 0; j < 6; j++){
                if(numbers.contains(splittedInput[j])){
                    System.out.println(numbers + " , " + splittedInput[j]);
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

    public static int recieveAmount(){
        Integer amount = Integer.parseInt(Console.readLine());

        validateRemainderIsZero(amount);
        validateQuotientIsMoreThanZero(amount);
        return amount / UNIT;

    }

    public static void validateRemainderIsZero(Integer amount){
        if(amount % 1000 != 0){
            throw new IllegalArgumentException("구입 금액은 " + UNIT + "원 단위 입니다.");
        }
    }

    public static void validateQuotientIsMoreThanZero(Integer amount){
        if(amount / 1000 <= 0){
            throw new IllegalArgumentException("최소 구입 금액은 " + UNIT + "원 입니다.");
        }
    }


}
