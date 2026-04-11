#include <iostream> 
#include <vector> 
#include <utility> 

using namespace std ; 

class Solution {
public:
    int minimumDistance(vector<int>& nums) {
        int n = nums.size() ; 
        int ans = INT_MAX ; 
        vector<pair<int,int>> mp( n+1 , {-1,-1} ) ; 
        for( int i=0 ; i<n ; ++i ){
            if( mp[ nums[i] ].first == -1 ){
                mp[ nums[i] ].first = i ; 
            }else if( mp[ nums[i] ].second == -1 ){
                mp[ nums[i] ].second = i ; 
            }else {
                ans = min( ans , ( i - mp[nums[i]].first ) << 1 ) ; 
                mp[ nums[i] ].first = mp[ nums[i] ].second ; 
                mp[ nums[i] ].second = i ; 
            }
        }
        return ans == INT_MAX ? -1 : ans ; 
    }
};