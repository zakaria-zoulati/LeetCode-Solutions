class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length ; 
        int m = waterStartTime.length ; 
        int rs = 9000 ; 
        for( int i=0 ; i<n ; ++i ){
            int a = landStartTime[i] + landDuration[i];
            for( int j=0 ; j<m ; ++j ){
                if( waterStartTime[j] <= a ){
                    rs = Math.min( rs , a + waterDuration[j]  ) ; 
                }else {
                    rs = Math.min( rs , waterStartTime[j] + waterDuration[j]  ) ; 
                }
            }
        }
        for( int i=0 ; i<m ; ++i ){
            int a = waterStartTime[i] + waterDuration[i];
            for( int j=0 ; j<n ; ++j ){
                if( landStartTime[j] <= a ){
                    rs = Math.min( rs , a + landDuration[j]  ) ; 
                }else {
                    rs = Math.min( rs , landStartTime[j] + landDuration[j]  ) ; 
                }
            }
        }

        return rs ; 
    }
}