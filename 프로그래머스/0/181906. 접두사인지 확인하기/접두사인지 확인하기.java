import java.util.*;

class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
        int idx = my_string.indexOf(is_prefix);
        if(idx==0) answer = 1;
        return answer;
    }
}