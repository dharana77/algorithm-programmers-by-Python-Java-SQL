package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
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

        public void sort() {
            this.points.sort(Comparator.comparingInt(p -> -p.getX()));
        }

        public boolean isFlying(){
            int cx = this.points.get(0).x;
            int cy = this.points.get(0).y;
            if(cx == R-1){
                System.out.println("first");
                return false;
            }else if(cy + 1 < C && arr[cx][cy+1] == 'x') {
                System.out.println("second" + cx + " " + cy);
                return false;
            }else if(cy - 1 >= 0 && arr[cx][cy-1] == 'x'){
                System.out.println("third");
                return false;
            }
            return true;
        }
    }

    public static class Pair{
        private int x;
        private int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return this.x;
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
            boolean[][] visited = new boolean[R][C];
            List<Cluster> clusters = findFlyingClusters(visited);
            //cluster를 높이 기준으로 정렬해서 저장하고, 클러스터 모음도 높이가 가장 낮은 것 기준으로 정렬해서 높이가 낮은 클러스터부터 중력을 적용시킨다.
            //그래야 클러스터 여러개 인데 다른 클러스터에 부딪쳐서 우선순위가 제대로 처리안될때 생기는 오류 수정할 수 있을 것으로 보인다.
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

    public static List<Cluster> findFlyingClusters(boolean[][] visited){
        List<Cluster> clusters = new ArrayList<>();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(!visited[i][j] && arr[i][j] == 'x'){
                    visited[i][j] = true;
                    Cluster cluster = new Cluster();
                    dfs(i, j, visited, cluster);
//                    System.out.println("before sorted");
                    for(int k=0; k<cluster.points.size(); k++){
                        Pair p = cluster.points.get(k);
                        System.out.println(p.x + " " + p.y);
                    }
                    cluster.sort();
//                    System.out.println("after sorted");
                    for(int k=0; k<cluster.points.size(); k++){
                        Pair p = cluster.points.get(k);
                        System.out.println(p.x + " " + p.y);
                    }
//                    System.out.println("=========");
//                    System.out.println(cluster.points.get(0).x + " " + cluster.points.get(0).y);
                    if(cluster.isFlying()) {
                        clusters.add(cluster);
                    }
                }
            }
        }
        clusters.sort(Comparator.comparingInt(cluster -> cluster.points.get(0).x));

        for(int i=0; i < clusters.size(); i++){
            Cluster cluster = clusters.get(i);
            for(int j=0; j<cluster.points.size(); j++){
                Pair p = cluster.points.get(j);
                System.out.println(p.x + " " + p.y);
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
                    visited[nx][ny] = true;
                    dfs(nx, ny, visited, cluster);
                }
            }
        }
    }

    public static void applyGravityForClusters(Cluster cluster) {
        List<Pair> points = cluster.points;
        for (int k = 0; k < points.size(); k++) {
            Pair p = points.get(k);
            int x = p.x;
            int y = p.y;

            for (int i = x; i < R; i++) {
                if (i + 1 < (R - 1) && arr[i][y] == 'x' && arr[i+1][y] == '.') {
                    arr[i+1][y] = 'x';
                    arr[i][y] = '.';
                }
            }
        }
    }
}

