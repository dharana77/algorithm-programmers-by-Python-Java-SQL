import java.util.*;
import java.util.stream.*;


class Solution {
    public int[] solution(int[] arr, int n) {
        IntStream.iterate((arr.length + 1) % 2, i -> i < arr.length, i -> i + 2)
                .forEach(i -> arr[i] += n);
        
        return arr;
    }
}