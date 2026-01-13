class Solution {
    public boolean check( long[] stations , int r , int k , long target ){
        int n = stations.length ; 
        long add = 0 ; 
        long curr = 0 ; 
        long[] mark = new long[n] ;
        for( int i=0 ; i<n ; ++i ){
            add -= mark[i] ; 
            if( stations[i] + add < target ){
                long diff = target - ( stations[i] + add ) ; 
                add += diff ; 
                if( i+2*r+1 < n ){
                    mark[i+2*r+1] = diff ; 
                }
                curr += diff ; 
            }
            if( curr > k ) return  false ; 
        } 
        return curr <= k ; 
    }
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length ; 
        long[] pref = new long[n] ; 
        pref[0] = stations[0] ; 
        for( int i=1 ; i<n ; ++i ){
            pref[i] = pref[i-1] + stations[i] ; 
        }
        long[] powers = new long[n] ; 
        for( int i=0 ; i<n ; ++i ){
            int low  = Math.max( i-r , 0 ) ; 
            int high = Math.min( i+r , n-1 ) ;
            powers[i] = pref[high] - ( low > 0 ? pref[low-1] : 0 ) ; 
        }
        long low = 0 ; 
        long high = (long) Math.pow( 10 , 11 ) ; 
        while( low < high ){
            long mid = low + ( high - low + 1 )/2 ; 
            if( check( powers , r , k , mid ) ){
                low = mid ; 
            }else {
                high = mid - 1 ; 
            }
        } 
        if( k == 25 ){
            check( powers , r , k , 34 ) ; 
        }
        return low ; 
    }
}