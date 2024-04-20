class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        myString = myString.replaceAll("A", "C");
        myString = myString.replaceAll("B", "A");
        myString = myString.replaceAll("C","B");
        // System.out.println(myString);
        if(myString.contains(pat)) answer = 1;
        return answer;
    }
}