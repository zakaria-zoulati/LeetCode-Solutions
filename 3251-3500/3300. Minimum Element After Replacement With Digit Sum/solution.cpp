#include <bits/stdc++.h> 

using namespace std ; 

class Solution {
public:
    int getSum( int n ){
        int ans = 0;
        while( n >0 ){
            ans += n % 10 ; 
            n /= 10 ; 
        } 
        return ans ; 
    }
    int minElement(vector<int>& nums) {
        int ans = INT_MAX; 
        for( int num : nums ){
            ans = min( ans , getSum(num) ) ;  
        }
        return ans ; 
    }
};