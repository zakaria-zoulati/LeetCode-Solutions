class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        if (n * m == 1) {
            return 0;
        }
        int mod = grid[0][0] % x;
        int[] axe = new int[10_001];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] % x != mod) {
                    return -1;
                } else {
                    grid[i][j] /= x;
                    axe[grid[i][j]]++;
                }
            }
        }
        int len = n * m;
        int count = 0;
        int mid = -1;
        for (int i = 0; i < 10_001; ++i) {
            count += axe[i];
            if (count * 2 >= len) {
                mid = i;
                break;
            }
        }
        int rs = 0;
        for (int[] i : grid) {
            for (int j : i) {
                rs += Math.abs(j - mid);
            }
        }
        return rs;
    }
}
