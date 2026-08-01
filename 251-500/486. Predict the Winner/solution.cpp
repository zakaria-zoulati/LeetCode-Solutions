#include <bits/stdc++.h>

using namespace std ; 

class Solution {
public:
    bool predictTheWinner(vector<int>& nums) {
        int n = nums.size();  
        int s = 0 ; 
        for( int num : nums ){
            s += num ; 
        }
        vector<vector<int>> dp( n , vector<int>(n,0) ) ; 
        for( int i=0 ; i<n ; ++i ){
            dp[i][i] = nums[i] ; 
        }

        for( int i=2 ; i<=n ; ++i ){
            for( int j=0 ; j+i-1<n ; ++j ){
                if( i == 2 ){
                    dp[j][j+1] = max( nums[j] , nums[j+1] ) ; 
                }else {
                    dp[j][j+i-1] = max(
                        nums[j] + min( dp[j+2][j+i-1] , dp[j+1][j+i-2] ) , 
                        nums[j+i-1] + min( dp[j+1][j+i-2] , dp[j][j+i-3] ) 
                    );
                }
            }
        }

        return ( s <= 2*dp[0][n-1] ) ; 
    }
};