class Solution {
    public double largestTriangleArea(int[][] pts) {
        double rs = 0;
        int n = pts.length;  
        for (int i = 0; i <n-2; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    double curr = Math.abs(
                        pts[i][0] * (pts[j][1] - pts[k][1]) +
                        pts[j][0] * (pts[k][1] - pts[i][1]) +
                        pts[k][0] * (pts[i][1] - pts[j][1])
                    ) / 2.0;
                    rs = Math.max(rs, curr);
                }
            }
        }
        return rs;
    }
}
