// class Solution {
//     int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

//     public int numIslands(char[][] grid) {
//         int res = 0;
//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[0].length; j++) {
//                 if (grid[i][j] == '1') {
//                     dfs(grid, i, j);
//                     res++;
//                 }
//             }
//         }
//         return res;
//     }

//     public void dfs(char[][] grid, int row, int col) {
//         if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != '1') {
//             return;
//         }

//         // visited
//         grid[row][col] = '0';

//         for (int[] dir : dirs) {
//             dfs(grid, row + dir[0], col + dir[1]);
//         }
//     }
// }



class Solution {
    // char[][] grider;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        // this.grider = grid;
        int count = 1;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                char c = grid[i][j];
                if(c == '1') {
                    count++;
                    dfs(grid, i, j, count);
                }
            }
        }
        return count - 1;
    }
    
    private void dfs(char[][] grider, int i, int j, int count) {
        //base
        if(i >= grider.length || i < 0 || j >= grider[0].length || j < 0 || grider[i][j] != '1') return;
        
        //logic
        grider[i][j] = 'A';
        for(int[] dir: dirs) {
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            dfs(grider, nr, nc, count);
        }
    }
}