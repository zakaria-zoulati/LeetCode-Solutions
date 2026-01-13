class Solution {
    int max = 0;
    int n;
    int m;
    int t;

    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    t = 0;
                    dfs(grid, i, j);
                    max = Math.max(t, max);
                }
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) {
            return;
        }
        t++;
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}