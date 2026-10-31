#include <bits/stdc++.h>

using namespace std ;

class Solution {
public:
    long long maxTotalValue(vector<int>& nums, int k) {
        long long mi = LLONG_MAX;
        long long ma = 0 ; 
        for( int num : nums ){
            mi = min( mi , num*1LL );
            ma = max( ma , num*1LL );
        }   
        return ( ma - mi )*k ; 
    }
};