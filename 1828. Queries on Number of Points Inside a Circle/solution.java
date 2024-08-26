class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int m = queries.length;
        int[] rs = new int[m];
        for (int i = 0; i < m; ++i) {
            int a = queries[i][0];
            int b = queries[i][1];
            int r = queries[i][2] * queries[i][2];
            
            for (int[] point : points) {
                int x = point[0];
                int y = point[1];
                if ((x - a) * (x - a) + (y - b) * (y - b) <= r ){
                    rs[i]++;
                }
            }
        }
        
        return rs;
    }
}
