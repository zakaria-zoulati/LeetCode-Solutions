#include <bits/stdc++.h>

using namespace std ; 

class Solution {
public:
    int missingMultiple(vector<int>& nums, int k) {
        int n = nums.size() ;
        vector<bool> f(n+1,false);
        for( int num : nums ){
            if( num % k == 0 ){
                if( num / k <= n ){
                    f[num/k] = true ; 
                }
            }
        }
        for( int i=1 ; i<=n ; ++i ){
            if( f[i] == false ){
                return i*k ; 
            }
        }
        return (n+1)*k ; 
    }
};