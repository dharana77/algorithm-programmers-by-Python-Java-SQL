import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] names) {
        String[] answer = IntStream.range(0, names.length).filter(x -> x%5 == 0).mapToObj(x -> names[x]).toArray(String[]::new);
        return answer;
    }
}