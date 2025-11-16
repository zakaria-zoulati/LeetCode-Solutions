using ll = long long ; 

class Solution {
public:
    ll countDistinct( ll n) {
        if( n < 10 ){
            return n ; 
        }
        vector<int> d; 
        while( n > 0 ){
            d.push_back( n%10 ) ; 
            n /= 10 ; 
        }
        int len = d.size() ; 
        vector<vector<ll>> dp( len , vector<ll>(2,0) ) ; 
        dp[len-1][0] = d[0] ; 
        dp[len-1][1] = 9 ; 
        for( int i=len-2 ; i>=0 ; --i ){
            int curr = d[len-1-i] ; 
            if( curr == 0 ){
                dp[i][0] = 0 ; 
            }else if( curr == 1 ){
                dp[i][0] = dp[i+1][0] ; 
            }else {
                dp[i][0] = dp[i+1][0] + ( curr - 1 )*dp[i+1][1] ;  
            }
            dp[i][1] = 9*dp[i+1][1] ; 
        }
        ll ans = dp[0][0] ; 
        for( int i=1 ; i<len ; ++i ){
            ans += dp[i][1] ; 
        }
        return ans ; 
    }
};