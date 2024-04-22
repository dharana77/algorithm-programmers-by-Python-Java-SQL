import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> temp = new ArrayList<>();
        
        while(n !=1){
            temp.add(n);
            if(n%2 == 0) n/=2;
            else n = n*3 +1;
        }
        temp.add(1);
        int[] answer = temp.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}