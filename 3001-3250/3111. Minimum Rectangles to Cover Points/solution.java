class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int n = points.length ; 
        Arrays.sort( points , (a,b) -> a[0] - b[0]  );
        int rs = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            ++rs ; 
            int r = points[i][0] ; 
            while( i+1<n && points[i+1][0] - r <= w ){
                ++i ; 
            }
        }
        return rs ; 
    }
}