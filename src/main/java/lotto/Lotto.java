package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호 리스트의 사이즈가 6이 아닙니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplication(List<Integer> numbers){
        Set<Integer> nonduplicateNumbers = Set.copyOf(numbers);
        if(nonduplicateNumbers.size() != numbers.size()){
            throw new IllegalArgumentException("로또 번호 리스트에 중복이 존재합니다.");
        }
    }
}
