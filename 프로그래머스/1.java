import java.util.*;

class Solution {
    public String[] solution(String[] logs) {
        String[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();

        Set<String> temp = new HashSet<>();
        for(int i=0; i<logs.length; i++){
            temp.add(logs[i]);
        }

        logs = temp.toArray(new String[0]);

        Set<String> users = new HashSet<>();

        for (int i=0; i<logs.length; i++){
            String[] log = logs[i].split(" ");
            String user = log[0];
            String problem = log[1];

            users.add(user);

            if (!map.containsKey(problem)){
                map.put(problem, 1);
            }else{
                int current = map.get(problem);
                map.put(problem, current+1);
            }
        }

        float userCount = users.size();

        List<String> ans = new ArrayList<>();

        float halfUserCount = userCount / 2;
        // System.out.println("userCount");
        // System.out.println(userCount);
        // System.out.println(userCount/2);
        for(String key : map.keySet()){
            int count = map.get(key);
            // System.out.println(key);
            // System.out.println(count);
            if(count >= halfUserCount){
                ans.add(key);
            }
        }

        answer = ans.toArray(new String[ans.size()]);
        Arrays.sort(answer);
        return answer;
    }
}
