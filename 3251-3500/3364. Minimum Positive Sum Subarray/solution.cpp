#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    int minimumSumSubarray(vector<int>& nums, int l, int r) {
        int n = nums.size(); 
        int ans = INT_MAX; 
        for( int i=0 ; i<n ; ++i ){
            int curr = 0 ; 
            for( int j=i ; j<n ; ++j ){
                curr += nums[j] ; 
                int len=j-i+1 ; 
                if( curr>0 && len>=l && len<=r ){
                    ans = min( ans, curr );
                }
            }
        }
        return ans==INT_MAX?-1:ans ; 
    }
};