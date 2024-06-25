import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		if(next_Permutation(a)) {
			for(int val : a) {
				sb.append(val).append(" ");
			}
		}else {
			sb.append("-1");
		}
	
		System.out.println(sb);
	}

	public static boolean next_Permutation(int a[]) {
		int i = a.length-1;

		while(i > 0 && a[i-1] >= a[i]) {
			i -= 1;
		}

		if(i<=0) return false; 
		
		int j = a.length - 1;
		
		while(a[i-1] >= a[j]) {
			j -= 1;
		}
        
		int temp = a[j];
		a[j] = a[i-1];
		a[i-1] = temp;
		
		j = a.length-1;
		
		while(i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i += 1;
			j -= 1;
		}
				
		return true;
	}
}