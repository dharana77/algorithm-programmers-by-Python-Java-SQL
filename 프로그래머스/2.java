class Solution {
    public String solution(String line) {
        String answer = "";
        int temp = 0;
        int cur = -1;
        Character currentChar = '-';

        for(int i=0; i<line.length(); i++){
            if(temp == 0){
                answer += line.charAt(i);
                cur += 1;
                currentChar = line.charAt(i);
                temp += 1;
            }else{
                if(currentChar == line.charAt(i)){
                    if(answer.charAt(cur) != '*'){
                        answer += "*";
                        cur += 1;
                    }
                }else{
                    answer += line.charAt(i);
                    cur += 1;
                    currentChar = line.charAt(i);
                }
            }
        }
        return answer;
    }
}
