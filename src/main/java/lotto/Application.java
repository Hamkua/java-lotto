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
         return amount / UNIT;
    }

}
