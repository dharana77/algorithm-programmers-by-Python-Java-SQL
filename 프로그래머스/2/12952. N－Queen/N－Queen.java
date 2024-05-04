class Solution {
    private static int[] board;
    private static int answer;
    
    public int solution(int n) {
        board = new int[n];
        
        backTracking(0, n);
        return answer;
    }
    
    public void backTracking(int row, int n){
        if(row == n) {
            answer += 1;
            return;
        }
        
        for(int i=0; i<n; i++){
            board[row] = i;
            if(valid(row)){
                // board[row] = i;   
                backTracking(row+1, n);
            }
        }
        
    }
    
    public boolean valid(int row){
        for(int i=0; i< row; i++){
            if(board[row] == board[i]) return false;
            if(Math.abs(row - i) == Math.abs(board[row] - board[i])) return false;
        }
        return true;
    }
    
}