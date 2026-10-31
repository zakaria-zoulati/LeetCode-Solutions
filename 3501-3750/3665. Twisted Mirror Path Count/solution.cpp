#include <bits/stdc++.h>

using namespace std; 

using vi = vector<int> ; 
using vvi = vector<vi> ; 
using vvvi = vector<vvi> ; 

const int mod = 1e9 + 7 ; 

int dp[501][501][2]  ; 

class Solution {
public:
    int uniquePaths( vvi& grid) {
        int n = grid.size(); 
        int m = grid[0].size();

        dp[0][0][0] = 1 ;
        
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                if( grid[i][j] == 0 ){
                    int curr = ( dp[i][j][0] + dp[i][j][1] ) % mod ; 
                    if( i+1<n ){
                        dp[i+1][j][1] = curr ;  
                    } 
                    if( j+1<m ){
                        dp[i][j+1][0] = curr ; 
                    }
                }else {
                    if( i+1<n ){
                        dp[i+1][j][1] = dp[i][j][0];  
                    }
                    if( j+1<m ){
                        dp[i][j+1][0] = dp[i][j][1];
                    }
                }
            }
        }

        int ans = ( dp[n-1][m-1][0] + dp[n-1][m-1][1] ) % mod ; 
        return ans ; 
    }
};