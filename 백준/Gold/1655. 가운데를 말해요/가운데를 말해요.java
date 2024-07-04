import java.io.*;  
import java.util.*;  
  
public class Main {  
  
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int n = Integer.parseInt(br.readLine());  
        StringBuilder sb = new StringBuilder();  

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();  
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());  
  
        for (int i = 0; i < n; i++) {  
            int x = Integer.parseInt(br.readLine());  

            if (maxHeap.isEmpty() || x <= maxHeap.peek()) {  
                maxHeap.offer(x);  
            } else {
                minHeap.offer(x);  
            }  

            if (maxHeap.size() > minHeap.size() + 1) {  
                minHeap.offer(maxHeap.poll());  
            } else if (minHeap.size() > maxHeap.size()) {  
                maxHeap.offer(minHeap.poll());  
            }  

            sb.append(maxHeap.peek()).append("\n");  
        }  
        System.out.println(sb);  
    }  
}