class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length; 
        int[] left = new int[n];
        int[] right = new int[n];
        int[] s = new int[n] ; 
        int in = -1 ;
        for (int i = 0; i < n; ++i) {
            while ( in != -1 && heights[s[in]] >= heights[i]) {
                in--;
            }
            left[i] = in == -1 ? 0 : s[in] + 1;
            s[++in] = i ; 
        }
        in = n ; 
        for (int i =n-1; i >= 0; --i) {
            while ( in != n && heights[s[in]] >= heights[i]) {
                in++;
            }
            right[i] = in == n ? n - 1 : s[in] - 1;
            s[--in] = i ; 
        }
        int rs = 0;
        for (int i = 0; i < n; ++i) {
            rs = Math.max(rs, (right[i] - left[i] + 1) * heights[i]);
        }
        return rs;
    }
}