import java.util.*;

class Solution {
    public int[] solution(int[][] recruits, int s1, int s2) {
        int[] answer = new int[2];

        int mx = 0;
        int e1mx = 0;
        int e2mx = 0;
        for(int e1=0; e1<=100; e1++){
            for(int e2=0; e2<=100; e2++){
                HashMap<String, Integer> map = getEachCountByRecruits(recruits, s1, s2, e1, e2);
                int expertCount = map.get("Expert");
                int seniorCount = map.get("Senior");
                int juniorCount = map.get("Junior");
                if(expertCount > 0 && expertCount < seniorCount && seniorCount < juniorCount){
                    if(mx <= (e1 + e2)){
                        if(mx == (e1 + e2)){
                            if(e1mx < e1){
                                e1mx = e1;
                                e2mx = e2;
                            }
                        }else{
                            e1mx = e1;
                            e2mx = e2;
                        }
                        mx = (e1 + e2);

                    }
                }
            }
        }
        answer[0] = e1mx;
        answer[1] = e2mx;
        return answer;

    }

    public HashMap<String, Integer> getEachCountByRecruits(int[][] recruits, int s1, int s2, int e1, int e2){
        HashMap<String, Integer> res = new HashMap<>();
        res.put("Junior", 0);
        res.put("Expert", 0);
        res.put("Senior", 0);

        for(int i=0; i<recruits.length; i++){
            int duration = recruits[i][0];
            int score = recruits[i][1];

            if(duration >= e1 && score >= e2){
                int prev = res.get("Expert");
                res.put("Expert", prev + 1);
            }else if(duration >= s1 || score >= s2){
                int prev = res.get("Senior");
                res.put("Senior", prev + 1);
            }else{
                int prev = res.get("Junior");
                res.put("Junior", prev + 1);
            }
        }

        return res;
    }
}
