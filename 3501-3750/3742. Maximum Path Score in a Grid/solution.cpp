#include <vector>

using namespace std ;

int dp[201][201][1001];

class Solution {
public:
    int maxPathScore(vector<vector<int>>& grid, int k) {
        int n = grid.size() ; 
        int m = grid[0].size() ; 
        
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                for( int t=0 ; t<=k ; ++t ){
                    dp[i][j][t] = -1 ; 
                }
            }
        }
        dp[0][0][0] = 0 ; 

        int curr_h = 0; 
        for( int i=1 ; i<m ; ++i ){
            if( grid[0][i] != 0 ){
                curr_h++ ; 
                if( curr_h <= k ){
                    dp[0][i][curr_h] = dp[0][i-1][curr_h-1] + grid[0][i] ;   
                }
            }else if( curr_h <= k ){
                dp[0][i][curr_h] = dp[0][i-1][curr_h] ; 
            }
        }
        int curr_v = 0 ; 
        for( int i=1 ; i<n ; ++i ){
            if( grid[i][0] != 0 ){
                curr_v++ ; 
                if( curr_v <= k ){
                    dp[i][0][curr_v] = dp[i-1][0][curr_v-1] + grid[i][0] ;   
                }
            }else if( curr_v <= k ){
                dp[i][0][curr_v] = dp[i-1][0][curr_v] ; 
            }
        }

        for( int i=1 ; i<n ; ++i ){
            for( int j=1 ; j<m ; ++j ){
                if( grid[i][j] == 0 ){
                    for( int t=0 ; t<=k ; ++t ){
                        dp[i][j][t] = max( dp[i-1][j][t] , dp[i][j-1][t] ) ;  
                    }
                }else {
                    for( int t=1 ; t<=k ; ++t ){
                        int can = max( dp[i-1][j][t-1] , dp[i][j-1][t-1] ) ; 
                        if( can != -1 ){
                            dp[i][j][t] = can + grid[i][j] ; 
                        }
                    }
                }
            }
        }

        int ans = -1 ; 
        for( int i=0 ; i<=k ; ++i ){
            ans = max( ans , dp[n-1][m-1][i] ) ; 
        }
        return ans ; 
    }
};