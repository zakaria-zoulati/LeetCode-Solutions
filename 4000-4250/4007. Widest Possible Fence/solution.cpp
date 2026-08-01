#include <bits/stdc++.h> 

using namespace std ; 

class Solution {
public:
    int maximumWidth(vector<int>& nums) {
        int n = nums.size() ; 
        sort( nums.begin() , nums.end() ) ; 
        map<int,int> m ; 
        for( int num : nums ){
            m[num]++ ; 
        }
        for( int i=0 ; i<n ; ++i ){
            int curr = 1 ;
            while( i+1<n && nums[i+1] == nums[i] ){
                curr++ ; 
                i++ ; 
            }
            m[ 2*nums[i] ] += curr/2 ; 
            for( int j=i+1 ; j<n ; ++j ){
                int curr_2 = 1 ; 
                while( j+1<n && nums[j+1] == nums[j] ){
                    curr_2++;
                    j++ ; 
                }
                m[ nums[i] + nums[j] ] += min( curr , curr_2 ) ; 
            }
        }

        int ans = 0 ; 
        for( auto &[k,v] : m ){
            ans = max( ans , v ) ; 
        }
        return ans ; 
    }
};