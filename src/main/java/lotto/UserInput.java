package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {

    public static final int UNIT = 1000;

    public static int purchaseAmountInput(){
        Integer amount = Integer.parseInt(Console.readLine());

        validateRemainderIsZero(amount);
        validateQuotientIsMoreThanZero(amount);
        return amount / UNIT;

    }

    public static List<Integer> winningNumbersInput(){
        String noSplittedInput = Console.readLine();
        String[] splittedInput = noSplittedInput.split(",");
        List<Integer> userWinningNumbers = stringArrayToIntList(splittedInput);

        validateUserWinningNumbersLength(userWinningNumbers);
        validateNumbersRange(userWinningNumbers);

        return userWinningNumbers;
    }

    public static int bonusNumberInput(){
        String bonusInput = Console.readLine();
        int bonus = Integer.parseInt(bonusInput);

        validateNumberRange(bonus);
        return bonus;
    }

    public static List<Integer> stringArrayToIntList(String[] before){
        List<Integer> after = new ArrayList();

        for(int i = 0; i<before.length; i++){
            after.add(Integer.parseInt(before[i]));
        }
        return after;
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

    private static void validateNumbersRange(List<Integer> numbers){
        for(Integer number : numbers){
            if(1 > number || number > 45){
                throw new IllegalArgumentException("로또 번호 리스트에 범위를 벗어난 수가 존재합니다.");
            }
        }
    }

    private static void validateNumberRange(int number){
        if(1 > number || number > 45){
            throw new IllegalArgumentException("로또 번호 리스트에 범위를 벗어난 수가 존재합니다.");
        }
    }

    public static void validateUserWinningNumbersLength(List<Integer> userWinningNumbers){
        if(userWinningNumbers.size() != 6){
            throw new IllegalArgumentException("당첨 번호는 6개 입니다.");
        }
    }


}
