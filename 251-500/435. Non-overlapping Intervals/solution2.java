class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int rs = 0 ; 
        int n =  intervals.length ; 
        Arrays.sort( intervals , (a,b) -> a[0]-b[0] ) ; 
        int end = Integer.MIN_VALUE; 
        int start = Integer.MIN_VALUE ; 
        for( int[] i : intervals ){
            if( i[0] == start ){
                end = Math.min( end , i[1] ) ; 
                rs++ ; 
            }
            else if( i[0] >= end ){
                start = i[0] ; 
                end   = i[1] ; 
            }
            else {
                rs++ ; 
                if( i[1] <= end ){
                    start = i[0] ; 
                    end = i[1] ; 
                }
            }
        }
        return rs ;
    }
}