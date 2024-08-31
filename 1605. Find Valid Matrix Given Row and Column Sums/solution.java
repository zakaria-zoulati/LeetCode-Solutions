class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] rs = new int[n][m];
        int curr = 0 ;  
        for (int i = 0; i < n; i++) {
            for (int j = curr ; j < m; j++) {
                if (rowSum[i] <= colSum[j]) {
                    rs[i][j] = rowSum[i];
                    colSum[j] -= rowSum[i];
                    rowSum[i] = 0;
                    break ; 
                } else {
                    rs[i][j] = colSum[j];
                    rowSum[i] -= colSum[j];
                    colSum[j] = 0;
                    curr++  ; 
                }
            }
        }
        return rs;
    }
}
