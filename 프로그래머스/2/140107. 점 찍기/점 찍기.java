import java.util.*;
import java.lang.Math;


class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        int temp = (int)d/k + 1;
        
        for(long i=0; i<=d; i+=k){
            long ds = (long)d*d;
            long is = (long)i*i;
            long e = (long)Math.sqrt(ds-is);
            long t = e/k + 1;
            answer += t;
        }
        return answer;
    }
}