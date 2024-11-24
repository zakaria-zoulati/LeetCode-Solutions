class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length; 
        int m = matrix[0].length; 
        int rs = 0; 
        int[][] sum = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == '1') {
                    sum[i][j] = 1;
                    if (j > 0) sum[i][j] += sum[i][j - 1];
                }
            }
        }
        for (int c = 0; c < m; ++c) {
            for (int c2 = c; c2 < m; ++c2) {
                int width = c2 - c + 1;
                if (width > n) break; 
                int start = 0, end = width - 1, cal = 0;
                for (int i = start; i <= end; ++i) {
                    cal += sum[i][c2] - (c == 0 ? 0 : sum[i][c - 1]);
                }
                if (cal == width * width) {
                    rs = Math.max(rs, width * width);
                    continue;
                }
                while (end + 1 < n) {
                    end++;
                    cal += sum[end][c2] - (c == 0 ? 0 : sum[end][c - 1]);
                    cal -= sum[start][c2] - (c == 0 ? 0 : sum[start][c - 1]);
                    start++;

                    if (cal == width * width) {
                        rs = Math.max(rs, width * width);
                        break;
                    }
                }
            }
        }
        return rs;
    }
}
