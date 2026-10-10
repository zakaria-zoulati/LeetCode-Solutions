class Solution {
public:
    int ans = 0 ; 
    bool isPrime( int n ){
        if( n == 2 || n == 3  ) return  true ; 
        if( n % 2 == 0 || n % 3 == 0  ) return false ; 
        return n == 5 || n == 7 || 
        n == 11 || n == 13 || n == 17 || n == 19 || 
        n == 23 || n == 27 || n == 31 ; 
    }
    int countBits( int n ){
        int ans = 0 ; 
        while( n > 0 ){
            n -= n & -n ; 
            ans++ ; 
        }
        return ans ; 
    }
    int countPrimeSetBits(int left, int right) {
        int ans = 0 ; 
        for( int i=left ; i<=right ; ++i ){
            if( isPrime( countBits(i) ) ){
                ans++ ; 
            }
        }
        return ans ; 
    }
};