class Solution {
    public int maximumRows(int[][] matrix, int numSelect) {
        int n = matrix.length; 
        int m = matrix[0].length; 
        int[] r = new int[n]; 
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == 1) {
                    r[i] |= (1 << j); 
                }
            }
        }
        int rs = 0 ; 
        int comb = (1 << numSelect) - 1;  
        int limit = 1 << m;
        while (comb < limit) {
            int s = 0;
            for (int j = 0; j < n; ++j) {
                if ((r[j] & comb) == r[j]) {
                    s++;
                }
            }
            rs = Math.max(rs, s);
            int x = comb & -comb;
            int y = comb + x;
            comb = ((comb & ~y) / x >> 1) | y;
        }

        return rs; 
    }
}
