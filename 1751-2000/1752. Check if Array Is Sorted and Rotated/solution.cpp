#include <bits/stdc++.h>

using namespace std ; 

class Solution {
public:
    bool check(vector<int>& nums) {
      int n = nums.size() ; 
      if( n <= 1 ) return true ; 
      int inv = 0 ; 
      for( int i=1 ; i<n ; ++i ){
        if( nums[i] < nums[i-1] ){
            inv++ ; 
            if( inv > 1 ) return false ; 
        }
      }        
      if( nums[n-1] > nums[0] ) inv++ ; 
      return inv <= 1 ; 
    }
};