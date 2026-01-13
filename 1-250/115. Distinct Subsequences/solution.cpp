class Solution {
    public:
        using ll = unsigned long long ; 
        int numDistinct(string s, string t) {
            int n = s.size() ; 
            int m = t.size() ; 
            if( m > n ) return 0 ; 
            vector<ll> dp(m+1,0) ; 
            dp[0] = 1 ; 
            for( int i=1 ; i<=n ; ++i ){
                for( int j=m ; j>0 ; --j ){
                    if( s[i-1] == t[j-1] ){
                        dp[j] += dp[j-1] ; 
                    }
                }
            }
            ll rs = dp[m] ; 
            return (int) rs ; 
        }
    };