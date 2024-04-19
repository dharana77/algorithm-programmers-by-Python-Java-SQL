import java.util.*;


class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = Arrays.stream(num_list).sorted().limit(5).toArray();
        return answer;
    }
}