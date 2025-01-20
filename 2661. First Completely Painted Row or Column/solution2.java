class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length ; 
        int m = mat[0].length ; 
        int k = arr.length ; 
        int[] map = new int[k + 1];
        for (int i = 0; i<k ; ++i) {
            map[arr[i]] = i;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <n; ++i) {
            int max = 0;
            for (int j = 0; j < m; ++j) {
                max = Math.max(max, map[mat[i][j]]);
            }
            ans = Math.min(ans, max);
        }
        for (int i = 0; i<m; ++i) {
            int max = 0;
            for (int j = 0; j<n; ++j) {
                max = Math.max(max, map[mat[j][i]]);
            }
            ans = Math.min(ans, max);
        }
        return ans;
    }
}