
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int m = Integer.parseInt(s.split(" ")[0]);
        int n = Integer.parseInt(s.split(" ")[1]);

        int[] isPrime = new int[n+1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = 1;
        }

        for (int i = 3; i <= n; i++) {
            for(int j=2; j*j<=i; j++) {
                if(i%j == 0) {
                    isPrime[i] = 0;
                    break;
                }
            }
        }

        for (int i = m; i <= n; i++) {
            if(isPrime[i] == 1) {
                System.out.println(i);
            }
        }

    }
}
