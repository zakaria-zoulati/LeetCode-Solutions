#include <iostream>
#include <vector>
#include <bitset>
#include <algorithm>

using namespace std ; 

class Solution {
    public:
        int lastStoneWeightII(vector<int>& stones) {
            int n = stones.size() ; 
            int sum = 0; 
            for( int i : stones ){
                sum += i ;
            }
            bitset<3'001> dp ; 
            dp[0] = 1 ; 
            for( int v : stones ){
                dp |= ( dp << v ) ; 
            }
            int rs = INT_MAX ; 
            for( int i=0 ; i<=sum ; ++i ){
                if( dp[i] ){
                    rs = min( rs , abs( sum - 2*i ) ) ; 
                }
            }
            return rs ; 
        }
    };