class Solution {
    public void gameOfLife(int[][] board) {
        //initially all cells are in 00 or 01 state.
        //0 -> 00
        //1 -> 01

        //00->0, 01->1, 10->2, 11->3
        //they can change to 00->10 or 01-> 11
        //00->10 (become live) -> when board[i][j] = 0 && liveNeighbors = 3
        //01->11 (can stay live) -> when board[i][j] = 1 && liveNeighbors = [2,3]

        //current state = board[i][j] & 1
        //next state = board[i][j] >> 1

        int m = board.length;
        int n = board[0].length;

        for(int i = 0;i<m; i++){
            for(int j = 0; j<n; j++){
                int lives = liveNeighbors(board, i, j, m, n);

                if(board[i][j] == 1 && lives>=2 && lives<=3){
                    board[i][j]=3; //01 -> 11
                }
                if(board[i][j]==0 && lives==3){
                    board[i][j]=2; //00-> 10
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;  // Get the 2nd state(current new state).
            }
        }
    }
    private int liveNeighbors(int[][] board, int i, int j, int m, int n){
        int lives = 0;
        for(int x = Math.max(i-1,0);x<=Math.min(i+1,m-1); x++){
            for(int y = Math.max(j-1,0);y<=Math.min(j+1,n-1); y++){
                lives = lives + (board[x][y] & 1);
            }
        }
        //now this counts the current cell also
        lives = lives - (board[i][j] & 1);
        return lives;
    }
}