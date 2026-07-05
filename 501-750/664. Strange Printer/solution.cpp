#include <bits/stdc++.h>

using namespace std ; 

class Solution {
public:
    int strangePrinter(string s) {
        int n = s.size(); 
        vector<vector<int>> dp( n , vector<int>(n,n));
        for( int i=0 ; i<n ; ++i ){
            dp[i][i] = 1 ; 
        }
        for( int i=2 ; i<=n ; ++i ){
            for( int j=0 ; j+i-1<n ; ++j ){
                if( s[j] == s[j+1] ){
                    dp[j][j+i-1] = dp[j+1][j+i-1] ; 
                }else if( s[j+i-1] == s[j+i-2] ){
                    dp[j][j+i-1] = dp[j][j+i-2];  
                }else {
                    dp[j][i+j-1] = dp[j][j+i-2] + 1; 
                    for( int k=j+i-2 ; k>=j ; --k ){
                        if( s[k] == s[j+i-1] ){
                            dp[j][i+j-1] = min( dp[j][j+i-1] , dp[j][k] + dp[k+1][j+i-2] ) ; 
                        }
                    }
                }
            }
        }
        return dp[0][n-1];
    }
};