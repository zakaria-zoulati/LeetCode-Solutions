#include <iostream> 
#include <vector> 
#include <cmath> 

using namespace std  ;

class Solution {
public:
    Solution() {
        ios_base::sync_with_stdio(false);
        cin.tie(nullptr);
        cout.tie(nullptr);
    }
    long long minOperations(vector<int>& nums1, vector<int>& nums2, int k) {
        int n = nums1.size() ; 
        if( k==0 ){
            for(int i=0 ; i<n ; ++i){
                if( nums1[i] != nums2[i]  ) return -1 ; 
            }
            return 0 ; 
        }
        long long rs = 0 ; 
        long long inter = 0 ; 
        for(int i=0 ; i<n ; ++i){
            int diff = nums1[i] - nums2[i] ; 
            if( diff % k != 0  ) return -1 ;  
            inter += diff/k ; 
            rs += abs(  diff/k ) ; 
        }

        if( inter == 0  ){
            return rs/2  ;
        }

        return -1 ; 

    }
};