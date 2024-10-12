class Solution {
    public int sumP( int n ){
        int sum = 0 ; 
        int i=2 ; 
        while( n % 2 == 0  ){
            n >>= 1 ; 
            sum += 2 ; 
        }
        ++i ; 
        while( n > 1 ){
            while( n % i == 0 ){
                n /= i ; 
                sum += i ; 
            }
            i += 2 ; 
        }
        return sum ; 
    }
    public int smallestValue(int n) {
        int k = 0 ;  
        while( true  ){
            k = sumP(n) ; 
            if( n == k ){
                return n ; 
            }else {
                n = k ; 
            }
        }
    }
}