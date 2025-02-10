class Solution {

    boolean found = false;
    int[][] dirs = {{0,1}, {0, -1}, {-1, 0}, {1, 0}};
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    board[i][j] = '#';
                    dfs(i, j, board, word, 1);
                    if(found) return true;
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return false;
    }

    public void dfs(int i, int j, char[][] board, String word, int match) {
        //base
        if(match == word.length()) {
            found = true;
            return;
        }
        //logic
        for(int[] dir: dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;
            if(r < board.length && c < board[0].length && r >= 0 && c >= 0 && board[r][c] != '#' && board[r][c] == word.charAt(match)) {
                board[r][c] = '#';
                dfs(r, c, board, word, match+1);
                board[r][c] = word.charAt(match);
            }
        }
    }






















    
    // boolean found = false;
    // int[][] dirs = {{0,1}, {0, -1}, {-1, 0}, {1, 0}};
    // public boolean exist(char[][] board, String word) {
    //     if(board == null || board.length == 0) return false;
    //     int m = board.length;
    //     int n = board[0].length;
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (board[i][j] == word.charAt(0)) {
    //                 board[i][j] = '#';
    //                 backtrack(board, i, j, m, n, word, 1);
    //                 if(found) return true;
    //                 board[i][j] = word.charAt(0);
    //             }
    //         }
    //     }
    //     return false;
    // }
    
    // private void backtrack(char[][] board, int r, int c, int m, int n, String word, int idx) {
    //     //base 
    //     if (idx == word.length()) {
    //         found = true;
    //         return;
    //     }
        
    //     //logic
    //     for (int[] dir: dirs) {
    //         int nr = r + dir[0];
    //         int nc = c + dir[1];
            
    //         if(nr < m && nc < n && nr >=0 && nc >=0 && board[nr][nc] != '#' && board[nr][nc] == word.charAt(idx)) {
    //             board[nr][nc] = '#';
    //             backtrack(board, nr, nc, m, n, word, idx +1);
    //             board[nr][nc] = word.charAt(idx);
    //         }
    //     }
        
    // }
}