import java.util.*;


class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int key = nums[i];
            if(h.containsKey(key)){
                h.put(nums[i], h.get(nums[i]) + 1);    
            }else{
                h.put(nums[i] , 1);
            }
        }
        
        List<Integer> keys = new ArrayList<>(h.keySet());
        
        keys.sort((k1, k2) -> h.get(k2).compareTo(h.get(k1)));
        
        int ln = h.size();
        int limit = nums.length / 2;
        if(limit <= ln) answer = limit;
        else answer = ln;
        
        return answer;
    }
}