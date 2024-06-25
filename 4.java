class Solution {

    public int solution(String[] grid) {
        int answer = 0;
        Character[][] map = new Character[1001][1001];
        //풀이 과정: 처음에는 위아래왼오른쪽 모두 #이 존재하면 영역내부라 생각했으나 밖이어도 위아래왼오른쪽이 #이 존재하는 경우 있음-> 도형 여러개일경우
        //따라서 이를 수정 한 풀이는
        //TODO 
        //.만 dfs하면서 큐나 set에 담고, 해당 .들중에 벽에 닿은 적이 없다면 영역 내부에 있으므로 #으로 전환
        // 그 후 #총갯수 세면 정답

        boolean[][] leftExist = new boolean[1001][1001];
        boolean[][] rightExist = new boolean[1001][1001];
        boolean[][] upExist = new boolean[1001][1001];
        boolean[][] downExist = new boolean[1001][1001];

        for(int i=0; i<grid.length; i++){
            boolean isLeftExist = false;
            for(int j=0; j<grid[i].length(); j++){
                if(grid[i].charAt(j) == '#') isLeftExist = true;
                if(isLeftExist) leftExist[i][j] = true;
            }
            boolean isRightExist = false;
            for(int j=grid[i].length()-1; j>=0; j--){
                if(grid[i].charAt(j) == '#') isRightExist = true;
                if(isRightExist) rightExist[i][j] = true;
            }
        }

        for(int j=0; j<grid[0].length(); j++){
            boolean isUpExist = false;
            for(int i=0; i<grid.length; i++){
                if(grid[i].charAt(j) == '#') isUpExist = true;
                if(isUpExist) upExist[i][j] = true;
            }
            boolean isDownExist = false;
            for(int i=grid.length-1; i>=0; i--){
                if(grid[i].charAt(j) == '#') isDownExist = true;
                if(isDownExist) downExist[i][j] = true;
            }
        }

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length(); j++){
                if(grid[i].charAt(j) == '.'){
                    if(leftExist[i][j] && rightExist[i][j] && upExist[i][j] && downExist[i][j]){
                        map[i][j] = '#';
                        answer += 1;
                    }else{
                        map[i][j] = '.';
                    }
                }else{
                    map[i][j] = '#';
                    answer += 1;
                }
            }
        }

        // for(int i=0; i<grid.length; i++){
        //     for(int j=0; j<grid[i].length(); j++){
        //         System.out.print(map[i][j]);
        //     }
        //     System.out.println();
        // }
        return answer;
    }
}
