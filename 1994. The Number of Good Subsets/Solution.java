class Solution {
    int[] primes = new int[]{ 2 , 3 , 5 , 7 , 11 , 13 , 17 , 19 , 23, 29 } ; 
    int mod = 1_000_000_007 ;
    long modE( int n ){
        if( n == 0 ) return 1 ; 
        if( n <= 30 ) return 1 << n ; 
        long rs = modE( n/2 ) ; 
        rs = ( rs * rs ) % mod ; 
        if( n % 2 == 1 ){
            rs = ( rs * 2 ) % mod ; 
        }
        return rs ;
    }
    int getMask( int n ){
        int mask = 0 ; 
        for( int i=0 ; i<10 ; ++i ){
            if( n % primes[i] == 0 ){
                if( (n/primes[i]) % primes[i] == 0 ) return -1; 
                mask |= ( 1 << i ) ; 
            }       
        }
        return mask ; 
    }
    public int numberOfGoodSubsets(int[] nums) {
        int n = nums.length ; 
        int mask = 1 << 10 ; 
        long[] dp = new long[mask] ; 
        dp[0] = 1 ; 
        int[] count= new int[31] ; 
        for( int num : nums ){
            count[num]++ ; 
        }
        for( int i=2 ; i<=30 ; ++i ){
            if( count[i] == 0 ) continue ; 
            int m = getMask(i) ;
            if( m != -1 ){
                for( int j=mask-1 ;j>=0 ; --j ){
                    if( ( j & m ) == 0 ){
                        dp[j|m] = ( dp[j|m] + dp[j] * count[i] ) % mod ; 
                    }
                }
            }  
        }
        long rs = 0 ; 
        for( int i=1 ; i<mask ; ++i ){
            rs = ( rs + dp[i] ) % mod ; 
        }
        rs = ( rs * modE(count[1])) % mod ; 
        return (int) rs ; 
    }
}