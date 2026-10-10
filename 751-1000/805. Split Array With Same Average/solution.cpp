#include <bits/stdc++.h>

using namespace std ;

class Solution {
public:
    bool possible( int sum , int n ){
        for( int i=1 ; i<n ; ++i ){
            if( sum * i % n == 0 ){
                return true ; 
            }
        }
        return false ; 
    }
    bool splitArraySameAverage(vector<int>& nums) {
        int n = nums.size();
        if( n == 1 ) return false ; 
        int sum = 0 ; 
        for( int num : nums ){
            sum += num;
        }    
        if( sum == 0 ) return true ;
        if( !possible( sum , n ) ){
            return false; 
        }
        
        int half = n/2 ; 
        vector<bitset<150'001>> dp( half+1 ) ; 
        dp[0][0] = true ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=min(half-1,i) ; j>=0 ; --j ){
                dp[j+1] |= ( dp[j] << nums[i] ) ; 
            }
        }

        for( int len=1 ; len<=half ; ++len ){
            if( sum * len % n == 0 && dp[len][sum*len/n] ){
                return true ; 
            }
        }

        return false ;  
    }
};