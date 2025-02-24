class Solution {
    public boolean isPrime( int n ){
        if( n == 2 || n == 3 ) return true ; 
        if( n % 2 == 0 || n % 3 == 0 ) return false ; 
        int i = 5 ; 
        while( i*i <= n ){
            if( n % i == 0 || n % (i+2) == 0 ){
                return false ; 
            }
            i += 6 ; 
        }
        return true ; 
    }
    public int numPrimeArrangements(int n) {
        int mod = 1_000_000_007 ; 
        int primes = 0 ; 
        for( int i=2 ; i<=n ; ++i ){
            if( isPrime(i) ) primes++ ; 
        }
        int others = n - primes ; 
        long rs = 1 ; 
        while( primes > 0 ){
            rs = ( rs * primes ) % mod ; 
            primes-- ; 
        }
        while( others > 0 ){
            rs = ( rs * others ) % mod ; 
            others-- ; 
        }
        return (int) rs ; 
    }
}