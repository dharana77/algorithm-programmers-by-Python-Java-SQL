import java.util.*;
import java.util.stream.*;


class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = Arrays.stream(strArr).filter(x -> !x.contains("ad")).toArray(String[]::new);        
        return answer;
    }
}