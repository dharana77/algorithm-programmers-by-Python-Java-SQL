import java.util.*;
import java.util.stream.*;


class Solution {
    public int solution(int n) {
        if(n % 2 == 1) return IntStream.range(1, n+1).filter(x -> x % 2 == 1).sum();
        return IntStream.range(1, n+1).filter(x -> x % 2 == 0).map(x -> x *x).sum();
    }
}