#include <bits/stdc++.h>

using namespace std ; 

class Solution {
public:
    long long cost( vector<int>& arr , int tar ){
        long long ans = 0 ;
        for( int val : arr ){
            ans += max( 0 , val - tar );
        }
        return ans;
    }
    bool check( vector<int>& vals , int tar , int ops ){
        return cost( vals , tar ) <= ops ; 
    }
    long long minSumSquareDiff(vector<int>& nums1, vector<int>& nums2, int k1, int k2) {
        int n = nums1.size();
        int ops = k1+k2 ; 
        for( int i=0 ; i<n ; ++i ){
            nums1[i] -= nums2[i] ;  
            nums1[i] = abs( nums1[i] ) ; 
        }
        
        int l = 0 ; 
        int r = 100'000 ; 
        while( l < r ){
            int mid = l + ( r - l )/2 ; 
            if( check( nums1 , mid , ops ) ){
                r = mid ; 
            }else {
                l = mid + 1 ; 
            }
        } 
        long long ans = 0 ; 
        if( l > 0 ){
            ans -= ( ops - cost( nums1 , l ) )*( 2*l - 1 ) ; 
        }
        for( int num : nums1 ){
            long long val = min( l , num ); 
            ans += val * val ; 
        }
        return ans ; 
    }
};