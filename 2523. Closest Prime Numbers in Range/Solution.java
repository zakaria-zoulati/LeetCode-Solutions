class Solution {
    public boolean isPrime( int n ){
        if( n == 3  ) return true ; 
        if( n % 3 == 0 ) return false ; 
        int i=5 ; 
        while( i*i <= n ){
            if( n % i == 0 || n % (i+2) == 0 ){
                return false ; 
            }
            i += 6 ; 
        }
        return true ;
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
            if( isPrime(left) ){
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