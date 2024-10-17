class Solution {
    public int findMinArrowShots(int[][] points) {
        int rs = 1 ; 
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int n = points.length ;  
        int end = points[0][1] ;
        for( int i=1 ; i<n ; ++i ){
            if( points[i][0] > end ){
                ++rs ; 
                end = points[i][1] ; 
            }
        }
        return rs ; 
    }
}