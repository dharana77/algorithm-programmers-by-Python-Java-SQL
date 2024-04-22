import java.util.*;


class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int tot = Arrays.stream(num_list).sum();
        int totSquare = tot * tot;
        int mulTot = Arrays.stream(num_list).reduce(1, (a,b) -> (a*b));
        if(mulTot < totSquare) answer = 1;
        return answer;
    }
}