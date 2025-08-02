class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length ; 
        int m = waterStartTime.length ; 
        int a = Integer.MAX_VALUE ; 
        int b = Integer.MAX_VALUE ; 
        int rs = Integer.MAX_VALUE ; 
        for( int i=0 ; i<n ; ++i ){
            a = Math.min( a , landStartTime[i] + landDuration[i] ) ; 
        }
        for( int i=0 ; i<m ; ++i ){
            b = Math.min( b , waterStartTime[i] + waterDuration[i] ) ; 
        }
        for( int i=0 ; i<m ; ++i ){
            if( waterStartTime[i] >= a ){
                rs = Math.min( rs , waterStartTime[i] + waterDuration[i] ) ; 
            }else {
                rs = Math.min( rs , a + waterDuration[i] ); 
            }
        }
        for( int i=0 ; i<n ; ++i ){
            if( landStartTime[i] >= b ){
                rs = Math.min( rs , landStartTime[i] + landDuration[i] ) ; 
            }else {
                rs = Math.min( rs , b + landDuration[i] ); 
            }
        }

        return rs ;
    }
}