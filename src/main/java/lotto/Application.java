package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static final int UNIT = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        recieveAmount();
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
