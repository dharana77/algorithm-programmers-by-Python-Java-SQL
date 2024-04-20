import java.util.*;
import java.util.stream.*;


class Solution {
    public int[] solution(String myString) {
        int[] answer = {};
        String[] splited = myString.split("x");
        
        answer = Arrays.stream(splited).mapToInt(x -> x.length()).toArray();
        
        if(myString.charAt(myString.length()-1) == 'x'){
            int[] new_answer = new int[answer.length+1];
            for(int i=0; i<answer.length; i++){
                new_answer[i] = answer[i];
            }
            // new_answer[answer.length+1] = 0;
            return new_answer;
        }
        return answer;
    }
}