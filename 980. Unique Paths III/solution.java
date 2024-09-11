class Solution {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int check(int[][] grid, int i, int j, boolean[][] isSeen, int emptyCells) {
        if (grid[i][j] == -1 || isSeen[i][j]) {
            return 0;
        }
        isSeen[i][j] = true;
        int rs = 0;
        if (grid[i][j] == 2) {
            if (emptyCells == 0) {
                rs = 1; 
            }
        } else {
            for (int[] di : directions) {
                int ni = i + di[0];
                int nj = j + di[1];
                if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length) {
                    rs += check(grid, ni, nj, isSeen, emptyCells - 1);
                }
            }
        }
        isSeen[i][j] = false;
        return rs;
    }
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isSeen = new boolean[m][n];
        int startI = 0, startJ = 0, emptyCells = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                } else if (grid[i][j] == 0) {
                    emptyCells++;
                }
            }
        }
        return check(grid, startI, startJ, isSeen , emptyCells + 1);
    }
}
