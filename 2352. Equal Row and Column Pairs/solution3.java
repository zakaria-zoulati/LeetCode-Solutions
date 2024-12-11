class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            for (int j = 0; j < n; j++) {
                row[j] = (char)(grid[i][j] );
            }
            String key = new String(row);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int sum = 0;
        for (int j = 0; j < n; j++) {
            char[] col = new char[n];
            for (int i = 0; i < n; i++) {
                col[i] = (char)(grid[i][j] );
            }
            String key = new String(col);
            sum += map.getOrDefault(key, 0);
        }
        return sum;
    }
}