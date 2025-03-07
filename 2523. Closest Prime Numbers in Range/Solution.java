class Solution {
    public static boolean notPrime[] = new boolean[1_000_001] ; 
    static {
        for( int i=4 ; i<=1_000_001 ; i+=2 ){
            notPrime[i] = true ; 
        }
        for( int i=3 ; (long) i*i<1_000_001 ; i += 2 ){
            if( notPrime[i] ) continue ; 
            for( int j = i*i ; j<1_000_001 ; j += i ){
                notPrime[ (int) j] = true ; 
            }
        }
    }
    public int[] closestPrimes(int left, int right) {
        int[] rs = new int[]{ -1 , -1  } ; 
        int curr = Integer.MAX_VALUE ; 
        int prev = -1 ;
        if( left <= 2 ){
            prev = 2 ; 
            left = 2 ; 
        }
        if( left % 2 == 0 ){
            left++ ; 
        }
        while( left <= right  ){
            if( !notPrime[left] ){
                if( prev != -1 && left - prev < curr ){
                    rs[0] = prev ; 
                    rs[1] = left ; 
                    curr = left - prev ; 
                }
                prev = left ; 
            }
            left += 2 ; 
        }

        return rs ;
    }
}