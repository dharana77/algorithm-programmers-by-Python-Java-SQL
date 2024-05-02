import java.util.*;


class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<prices.length; i++){
            if(st.size() == 0){
                st.push(i);
                // System.out.println(1);
            }
            else{
                if(prices[st.peek()] > prices[i]){
                    while(st.size() > 0 && (prices[st.peek()] > prices[i])){
                        int temp = st.pop();
                        answer[temp] = i - temp;
                    }
                    st.push(i);
                    // System.out.println(2);
                }else{
                    st.push(i);
                    // System.out.println(3);
                }
            }
            // System.out.println(st.peek());
        }
        while(st.size()>0){
            int temp = st.pop();
            answer[temp] = prices.length - 1 - temp;
        }
        //java queue에 pair넣는 법알기
        
        return answer;
    }
}