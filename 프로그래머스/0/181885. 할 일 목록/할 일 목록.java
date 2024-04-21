import java.util.*;
import java.util.stream.*;


class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        String[] answer = IntStream.range(0, todo_list.length).filter(x -> !finished[x]).mapToObj(x -> (String)todo_list[x]).toArray(String[]::new);
        
        return answer;
    }
}