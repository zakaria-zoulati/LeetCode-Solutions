#include <bits/stdc++.h>

using namespace std ; 

class Solution {
public:
    int sumCounts(vector<int>& nums) {
        int ans = 0 ; 
        vector<int> f( 101 , false ) ; 
        int count = 0 ; 
        for( int i=0 ; i<nums.size() ; ++i ){
            for( int j=i ; j<nums.size() ; ++j ){
                if( !f[nums[j]] ){
                    count++ ;
                    f[nums[j]] = true ;  
                }
                ans += count*count ; 
            }
            fill( f.begin() , f.end() , 0 ) ;
            count = 0 ;  
        }
        return ans ;
    }
};