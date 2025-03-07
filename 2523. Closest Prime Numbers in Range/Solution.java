class Solution {
    public static boolean notPrime[] = new boolean[1_000_001] ; 
    public static int[] transaction = new int[ 1_000_001 ] ; 
    static {
        notPrime[1] = true ; 
        for( int i=4 ; i<=1_000_001 ; i+=2 ){
            notPrime[i] = true ; 
        }
        int prev = 2 ; 
        for( int i=3 ; (long) i<1_000_001 ; i += 2 ){
            if( notPrime[i] ) continue ; 
            transaction[ prev ] = i - prev ; 
            transaction[i] = 1_000_001 ; 
            prev = i ; 
            for( long j = (long) i*i ; j<1_000_001 ; j += i ){
                notPrime[ (int) j] = true ; 
            }
        }
    }
    public int[] closestPrimes(int left, int right) {
        int[] rs = new int[]{ -1 , -1  } ; 
        int curr = Integer.MAX_VALUE ; 
        int prev = -1 ;
        if( left <=  2 ){
            prev = 2 ; 
            left = 3 ; 
        }else {
            if( left % 2 == 0 ) left++ ; 
            while( left<right && notPrime[left] ){
                left += 2 ; 
            }
            prev = left ; 
            if( left >= right || notPrime[left] ) return rs ;
            left += transaction[left] ; 
        }

        while( left <= right  ){
            if( (left - prev) < curr ){
                rs[0] = prev ; 
                rs[1] = left ; 
                curr = left - prev ; 
            }
            prev = left ; 
            left += transaction[left] ; 
        }

        return rs ;
    }
}