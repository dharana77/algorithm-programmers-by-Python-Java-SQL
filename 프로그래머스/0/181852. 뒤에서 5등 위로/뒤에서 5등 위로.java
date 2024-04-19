import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;



class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = Arrays.stream(num_list).sorted().skip(5).toArray();  
        return answer;
    }
}