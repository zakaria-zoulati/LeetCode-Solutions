class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int rs = 0 ; 
        int n =  intervals.length ; 
        Arrays.sort( intervals , (a,b) -> a[0]-b[0] ) ; 
        int end = intervals[0][1] ; 
        int start = intervals[0][0] ; 
        for( int i=1 ; i<n ; ++i ){
            if( intervals[i][0] == start ){
                end = Math.min( end , intervals[i][1] ) ; 
                rs++ ; 
            }
            else if( intervals[i][0] >= end ){
                start = intervals[i][0] ; 
                end   = intervals[i][1] ; 
            }
            else {
                rs++ ; 
                if( intervals[i][1] <= end ){
                    start = intervals[i][0] ; 
                    end = intervals[i][1] ; 
                }
            }
        }
        return rs ;
    }
}