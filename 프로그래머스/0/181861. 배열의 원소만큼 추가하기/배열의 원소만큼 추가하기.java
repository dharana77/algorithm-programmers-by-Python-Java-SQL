import java.util.*;


class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> arrList = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            int count = arr[i];
            int temp = count;
            while(count > 0){
                arrList.add(temp);
                count--;
            }
                
        }
        answer = arrList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}