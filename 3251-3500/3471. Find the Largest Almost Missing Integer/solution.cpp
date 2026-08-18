#include <bits/stdc++.h>

using namespace std ; 

class Solution {
public:
    int largestInteger(vector<int>& nums, int k) {
        int n = nums.size() ; 
        if( n == k ){
            int ans = -1  ;
            for( int num : nums ){
                ans = max( ans , num ) ; 
            }
            return ans ; 
        }
        vector<int> f( 51 , 0 ); 
        for( int num : nums ){
            f[num]++ ; 
        }
        if( k == 1 ){
            int ans = -1 ; 
            for( int num : nums ){
                if( f[num] == 1 ){
                    ans = max( ans , num ); 
                }
            }
            return ans ; 
        }

        int ans = -1 ; 
        if( f[nums[0]] == 1 ){
            ans = nums[0] ; 
        }
        if( f[nums[n-1]] == 1 ){
            ans = max( ans , nums[n-1] ) ; 
        }
        return ans ; 
    }
};