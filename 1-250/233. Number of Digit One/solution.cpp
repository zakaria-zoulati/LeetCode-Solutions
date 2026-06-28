#include <bits/stdc++.h> 

using namespace std ; 

class Solution {
public:
    int countDigitOne(int n) {
        if( n == 0 ){
            return 0 ; 
        }
        if( n < 10 ) {
            return 1 ; 
        }
        
        vector<int> digits ; 
        while( n > 0 ){
            digits.push_back( n % 10 ) ; 
            n /= 10 ; 
        }
        int len = digits.size() ; 
        
        vector<vector<long long>> dp( len , vector<long long>(2,0) );
        dp[0][0] = 1 ; 
        if( digits[0] >= 1 ){
            dp[0][1] = 1 ; 
        }

        long long prev = 10 ; 
        long long suff = digits[0] ; 
        long long pow = 10 ;
        for( int i=1 ; i<len ; ++i ){
            dp[i][0] = dp[i-1][0]*10 + prev ; 
            if( digits[i] == 0 ){
                dp[i][1] = dp[i-1][1] ; 
            }else if( digits[i] == 1 ){
                dp[i][1] = dp[i-1][0] + dp[i-1][1] + suff + 1 ; 
            }else {
                dp[i][1] = ( digits[i] )*dp[i-1][0] + prev + dp[i-1][1] ; 
            }
            prev *= 10 ; 
            suff += digits[i]*pow ; 
            pow *= 10 ; 
        }

        return (int) dp[len-1][1] ; 
    }
};