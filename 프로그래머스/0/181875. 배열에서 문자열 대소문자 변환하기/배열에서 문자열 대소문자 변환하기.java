import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = {};
        List<String> arr = new ArrayList<>();
        
        for(int i=0;i<strArr.length; i++){
            if(i%2 ==0){
                arr.add(strArr[i].toLowerCase());
            }else{
                arr.add(strArr[i].toUpperCase());
            }
        }
        answer = arr.stream().toArray(String[]::new);
        return answer;
    }
}