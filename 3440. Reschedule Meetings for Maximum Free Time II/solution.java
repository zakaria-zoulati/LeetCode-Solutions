class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int k=1 ; 
        int n = startTime.length ; 
        int rs = 0 ; 
        int[] holes = new int[n+1] ; 
        holes[0] = startTime[0] ; 
        holes[n] = eventTime - endTime[n-1] ; 
        for( int i=1 ; i<n ; ++i ){
            holes[i] = startTime[i] - endTime[i-1] ; 
        }
        int[] maxRight = new int[n+1] ; 
        int[] maxLeft = new int[n+1] ; 
        maxRight[n] = holes[n] ; 
        maxLeft[0] = holes[0] ; 
        for( int i=n-1 ; i>=0 ; --i ){
            maxRight[i] = Math.max( holes[i] , maxRight[i+1] ) ; 
        }
        for( int i=1 ; i<=n ; ++i ){
            maxLeft[i] = Math.max( holes[i] , maxLeft[i-1] ) ; 
        }
        for( int i=0 ; i<n ; ++i ){
            int curr = holes[i] + holes[i+1] ; 
            int dur = endTime[i] - startTime[i] ; 
            if( i >= 1  ){
                 if( maxLeft[i-1] >= dur ){
                     curr += dur ; 
                     rs = Math.max( rs , curr ) ; 
                     continue ; 
                 }   
            }
            if( i < n-1 ){
                if( maxRight[i+2] >= dur ){
                     curr += dur ; 
                     rs = Math.max( rs , curr ) ; 
                     continue ; 
                }
            }
            rs = Math.max( rs , curr ) ;
        }

        return rs ; 
    }
}