import java.util.*;
import java.util.stream.*;


class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int odds = IntStream.range(0, num_list.length).filter(x -> x%2 == 1).map(x -> num_list[x]).sum();
        int evens = IntStream.range(0, num_list.length).filter(x -> x%2 == 0).map(x -> num_list[x]).sum();
        answer = Math.max(odds, evens);
        return answer;
    }
}