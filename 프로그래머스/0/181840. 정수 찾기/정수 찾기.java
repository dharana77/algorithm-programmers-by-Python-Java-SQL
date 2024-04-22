import java.util.*;


class Solution {
    public int solution(int[] num_list, int n) {
        int answer = 0;
        Long ct = Arrays.stream(num_list).filter(x -> x == n).count();
        Long test = 1L;
        int test2 = test.intValue();
        if(ct >= 1) answer = 1;
        return answer;
    }
}