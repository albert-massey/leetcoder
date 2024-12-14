class Solution {
    int[][] dirs = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    int m = 0;
    int n = 0;
    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        if(board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        board[click[0]][click[1]] = 'B';
        q.add(click);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int mines = countMines(board, curr[0], curr[1]);
                if(mines != 0) {
                    board[curr[0]][curr[1]] = (char) (mines + '0');
                } else{
                    for(int[] dir: dirs) {
                        int nr = dir[0] + curr[0];
                        int nc = dir[1] + curr[1];
                        //bounds
                        if(nr >= 0 && nc >= 0 && nr < m && nc  < n    ) {
                            if(board[nr][nc] == 'E') {
                                board[nr][nc] = 'B';
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }
        return board;
    }
    
    public int countMines(char[][] board, int r, int c) {
        int count = 0;
        for(int[] dir: dirs) {
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            //bounds
            if(nr >= 0 && nc >= 0 && nr < m && nc  < n) {
                if(board[nr][nc] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }
}