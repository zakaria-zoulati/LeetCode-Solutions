class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length ; 
        int rs = 0 ; 
        int[] pref = new int[n+1] ;
        pref[0] = startTime[0] ; 
        pref[n] = eventTime - endTime[n-1] ; 
        for( int i=1 ; i<n ; ++i ){
            pref[i] = startTime[i] - endTime[i-1] ; 
        }
        int next = 0 ; 
        for( int i=1 ; i<=k ; ++i ){
            next += pref[i] ; 
        }
        rs = pref[0] + next ; 
        for( int i=2 ; i+k-1<=n ; ++i ){
            next -= pref[i-1] ;
            next += pref[i+k-1] ; 
            rs = Math.max( rs , pref[i-1] + next  ) ; 
        }    
        return rs ; 
    }
}