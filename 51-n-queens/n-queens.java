class Solution {
    private boolean valid(char[][] board, int row, int col){
        //top left diagonal-> row-1,col-1
        int dupRow = row;
        int dupCol = col;
        while(row>=0 && col>=0){
            if(board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }
        row = dupRow;
        col = dupCol;
        //left -> col-1
        while(col>=0){
            if(board[row][col] == 'Q')
                return false;
            col--;
        }
        col = dupCol;
        //bottom left -> row+1, col-1
        while(row<board.length && col>=0){
            if(board[row][col] == 'Q')
                return false;
            row++;
            col--;
        }
        return true;
    }
    private List<String> makeList(char[][] board){
        List<String> boardAsList = new ArrayList<>();
        for(char[] row : board){
            boardAsList.add(new String(row));
        }
        return boardAsList;
    }
    private void helper(List<List<String>> res, char[][] board, int col, int n){
        //base  case would be that we are exhausted with column boundary
        if(col == n){
            res.add(makeList(board));
            return;
        }
        //move along the rows and check validity
        for(int row = 0;row<n; row++){
            if(valid(board, row, col)){
                board[row][col] = 'Q';
                helper(res, board, col+1, n);
                board[row][col] = '.'; //backtrack
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        //for a particular column try out placing the queen at each row and check if it is valid to keep at that position.

        //firstly populate empty '.' loaded board
        char[][] board = new char[n][n];
        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }

        helper(res, board, 0, n);
        return res;
    }

}