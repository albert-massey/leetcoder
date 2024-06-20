class Solution {
    public boolean isRobotBounded(String instructions) {
        HashSet<int[]> set = new HashSet<>();
        //               north    east    south     west
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        //                idx
        int idx = 0;
        int x = 0;
        int y = 0;
        char[] insArr = instructions.toCharArray(); 
        for(char c: insArr) {
            if(c == 'G') {
                x += dirs[idx][0];
                y += dirs[idx][1];
            } else if(c == 'L') {
                idx = (idx + 3) % 4;
            } else if(c == 'R') {
                idx = (idx + 1) % 4;
            }
        }
        return  idx != 0 || (x == 0 && y == 0);
    }
}