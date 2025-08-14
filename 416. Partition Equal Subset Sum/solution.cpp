#include <iostream> 
#include <bitset>
#include <vector>

using namespace std ; 

class Solution {
    public:
        bool canPartition(vector<int>& nums) {
            int sum = 0 ; 
            for( int i : nums ){
                sum += i ; 
            }
            if( sum % 2 == 1 ) return false ; 
            bitset<20'001> dp ;
            dp[0] = 1 ; 
            for( int i : nums ){
                dp |= ( dp << i ) ; 
            }
            return dp[sum/2] ; 
        }
    };