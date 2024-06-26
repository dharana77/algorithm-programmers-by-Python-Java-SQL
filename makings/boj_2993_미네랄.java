package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static char[][] arr;
    private static int R, C, N;
    private static StringBuilder sb = new StringBuilder();

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static class Cluster{
        private List<Pair> points = new ArrayList<>();
    }

    public static class Pair{
        private int x;
        private int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
//            System.out.println(st);
            String line = st.nextToken();
            System.out.println(line);
            for(int j=0; j<C; j++){
                arr[i][j] = line.charAt(j);
            }
        }

        N =  Integer.valueOf(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int h = Integer.valueOf(st.nextToken());
            if(i%2 == 0){
                startFromLeft(h);
            }else{
                startFromRight(h);
            }
            List<Cluster> clusters = findFlyingClusters();
            //cluster에 minHeight 추가 및 minHeight 기준으로 정렬해야 할듯
            //그래야 클러스터 여러개 인데 다른 클러스터에 부딪쳐서 우선순위가 제대로 처리안될때 생기는 오류 수정할 수 있을듯
            for (int k=0; k< clusters.size(); k++){
                applyGravityForClusters(clusters.get(k));
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void startFromLeft(int h){
        for(int i=0; i<C; i++){
            if(arr[R-h][i] == 'x'){
                arr[R-h][i] = '.';
                break;
            }
        }
    }

    public static void startFromRight(int h){
        for(int i=C-1; i>=0; i--){
            if(arr[R-h][i] == 'x'){
                arr[R-h][i] = '.';
                break;
            }
        }
    }

    public static List<Cluster> findFlyingClusters(){
        boolean[][] visited = new boolean[R][C];
        List<Cluster> clusters = new ArrayList<>();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(arr[i][j] == 'x' && !visited[i][j]){
                    Cluster cluster = new Cluster();
                    dfs(i, j, visited, cluster);
                    clusters.add(cluster);
                }
            }
        }
        return clusters;
    }

    public static void dfs(int x, int y, boolean[][] visited, Cluster cluster){
        visited[x][y] = true;
        cluster.points.add(new Pair(x, y));

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < R && ny >= 0 && ny < C){
                if(arr[nx][ny] == 'x' && !visited[nx][ny]){
                    dfs(nx, ny, visited, cluster);
                }
            }
        }
    }

    public static void applyGravityForClusters(Cluster cluster){
        for(int j=0; j<C; j++){
            for(int i=R-1; i>=0; i--){
                if(i-1 >=0 && arr[i-1][j] == 'x' && arr[i][j] == '.'){
                    arr[i][j] = 'x';
                    arr[i-1][j] = '.';
                }
            }
        }
    }
}

