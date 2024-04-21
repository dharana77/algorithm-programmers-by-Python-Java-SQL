import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int k) {
        int[] answer = IntStream.range(1, n+1).filter(x -> x%k == 0).toArray();
        return answer;
    }
}