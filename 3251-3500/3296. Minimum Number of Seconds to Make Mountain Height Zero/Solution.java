class Solution {
    public boolean check( int[] coeffs , int target , long seconds ){ 
        long cutted = 0 ; 
        for( int i=0 ; i<coeffs.length ; ++i ){ 
            long l = (long)((-1 + Math.sqrt(1 + 8.0*seconds/coeffs[i]))/2 );
            cutted += l ; 
            if( cutted >= target ) return true ; 
        }
        return false ; 
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long l = 1 ; 
        long r = (long) Math.pow( 10 , 16 ) ; 
        while( l < r ){
            long mid = l + (( r-l )>>1) ; 
            if( check( workerTimes , mountainHeight , mid ) ){
                r = mid ; 
            }else {
                l = mid + 1 ; 
            }
        }
        return l ; 
    }
}