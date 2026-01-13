class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort( points , (a,b) -> a[0] - b[0] );
        int rs = 0 ; 
        int rightBound = -1 ; 
        for( int[] i : points ){
            if( i[0] > rightBound ){
                rightBound = i[0] + w ; 
                ++rs ; 
            }
        }
        return rs ; 
    }
}