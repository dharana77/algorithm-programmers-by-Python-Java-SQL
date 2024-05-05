import java.util.*;
import javafx.util.Pair;
import java.util.stream.*;


class Solution {
    private int[] dx;
    private int[] dy;
    private int[][] board;
    private boolean[][] visited;
    private int[] oil;
    
    public int solution(int[][] land) {
        int answer = 0;
        board = land;
        dx = new int[]{0,0, -1, 1};
        dy = new int[]{1,-1, 0, 0};
        visited = new boolean[board.length][board[0].length];
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        
        oil = new int[land[0].length];
        
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(!visited[i][j] && land[i][j] == 1) bfs(i,j);
            }
        }
        
        answer = Arrays.stream(oil).max().getAsInt();
        return answer;
    }
    
    
    public void bfs(int i, int j){
        if(board[i][j] != 1) return;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(i,j));
        int res = 1;
        Set<Integer> visitedCols = new HashSet<>();
        
        while(q.size() > 0){
            Pair<Integer, Integer> p = q.poll();
            int x = p.getKey();
            int y = p.getValue();
            visitedCols.add(y);
            
            visited[x][y] = true;
            
            for(int k=0; k<4; k++){
                int nx = dx[k] + x;
                int ny = dy[k] + y;
                if (nx >= 0 && nx < board.length && ny >=0 && ny < board[0].length){
                    if(board[nx][ny] == 1 && !visited[nx][ny]){
                        // System.out.println("x:" + nx + " y:"+ny);
                        visited[nx][ny] = true;
                        q.add(new Pair(nx,ny));
                        res+=1;
                    }
                }
            }
        }
        for(int k: visitedCols){
            oil[k] += res;
        }
        
        return;
    }
}