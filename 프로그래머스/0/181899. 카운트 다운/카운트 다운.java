import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int start, int end_num) {
        int[] answer = IntStream.range(end_num, start+1).boxed().sorted(Collections.reverseOrder()).mapToInt(x -> x).toArray();
        return answer;
    }
}