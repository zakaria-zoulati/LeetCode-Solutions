#include <bits/stdc++.h>

using namespace std ; 

class Solution {
public:
    int firstStableIndex(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> suff_min(n);
        suff_min[n-1] = nums[n-1];
        for( int i=n-2 ; i>=0 ; --i ){
            suff_min[i] = min( suff_min[i+1] , nums[i] );
        }
        if( nums[0] - suff_min[0] <= k ){
            return 0;
        }
        int pref = nums[0] ; 
        for( int i=1 ; i<n ; ++i ){
            if( nums[i] > pref ) pref = nums[i]; 
            if( pref - suff_min[i] <= k ){
                return i ; 
            }
        }
        return -1; 
    }
};