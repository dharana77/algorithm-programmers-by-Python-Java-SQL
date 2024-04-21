import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = Arrays.stream(num_list).skip(n-1).toArray();
        return answer;
    }
}