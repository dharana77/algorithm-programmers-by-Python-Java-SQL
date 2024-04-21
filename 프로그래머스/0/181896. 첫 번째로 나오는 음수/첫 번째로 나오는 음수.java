import java.util.*;
import java.util.stream.*;


class Solution {
    public int solution(int[] num_list) {
        OptionalInt s = IntStream.range(0, num_list.length).filter(x -> num_list[x] < 0).findFirst();
        int answer = -1;
        if(s.isPresent()) answer = s.getAsInt();
        return answer;
    }
}