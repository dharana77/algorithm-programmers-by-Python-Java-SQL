
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] >= S) min = 1;
        }

        int start = 0;
        int end = 0;
        while (end <= N){
            if (sum >= S){
                min = Math.min(min, end-start);
                sum -= arr[start];
                start += 1;
            }else{
                sum += arr[end];
                end += 1;
            }
        }
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        System.out.println(min);
    }
}