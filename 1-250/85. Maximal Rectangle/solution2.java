class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int rs = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            rs = Math.max( rs, largestRectangleArea(heights)  );
        }
        return rs;
    }

    private int largestRectangleArea(int[] heights ) {
        int n = heights.length; 
        int[] left = new int[n];
        int[] right = new int[n];
        // Stack<Integer> stack = new Stack<>();
        int[] s = new int[n] ; 
        int in = -1 ;
        // Fill left boundaries
        for (int i = 0; i < n; ++i) {
            while ( in != -1 && heights[s[in]] >= heights[i]) {
                in--;
            }
            left[i] = in == -1 ? 0 : s[in] + 1;
            s[++in] = i ; 
        }

        in = n ; 
        // Fill right boundaries
        for (int i =n -1; i >= 0; --i) {
            while ( in != n && heights[s[in]] >= heights[i]) {
                in++;
            }
            right[i] = in == n ? n - 1 : s[in] - 1;
            s[--in] = i ; 
        }
        // Calculate the maximum area
        int rs = 0;
        for (int i = 0; i < n; ++i) {
            rs = Math.max(rs, (right[i] - left[i] + 1) * heights[i]);
        }
        return rs;
    }
}
