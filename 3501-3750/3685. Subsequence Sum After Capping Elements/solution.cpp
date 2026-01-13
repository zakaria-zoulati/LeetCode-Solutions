#include <iostream> 
#include <vector>
#include <bitset>
#include <algorithm> 

using namespace std ; 

class Solution {
    public:
        vector<bool> subsequenceSumAfterCapping(vector<int>& nums, int k) {
            int n = nums.size() ; 
            int sum = 0 ; 
            for( int i : nums ){
                sum += i ; 
            }
            vector<bool> rs(n , false) ; 
            if( sum < k ) return rs ; 
            sort( nums.begin() , nums.end() ) ;
            bitset<4'001> b ; 
            b[0] = 1 ;
            int in = 0 ; 
            for( int i=1 ; i<=n ; ++i ){
                while( in < n && nums[in] <= i ){
                    b |= ( b << nums[in] ) ; 
                    in++ ; 
                }
                int right=( n-in );
                for( int j=0 ; j<=k ; ++j ){
                    if( b[j] ){
                        int rem = k - j ; 
                        if( rem % i == 0 && rem <= right*i ){
                            rs[i-1] = true ; 
                            break ; 
                        }
                    }
                }
            }
            return rs ; 
        }
    };