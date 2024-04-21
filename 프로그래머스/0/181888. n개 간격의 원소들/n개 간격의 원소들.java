import java.util.*;
import java.util.stream.*;


class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = IntStream.range(0, num_list.length).filter(x -> x%n == 0).map(x -> num_list[x]).toArray();
        return answer;
    }
}