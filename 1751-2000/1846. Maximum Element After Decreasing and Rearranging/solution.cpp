#include <bits/stdc++.h> 

using namespace std ; 

class Solution {
public:
    int maximumElementAfterDecrementingAndRearranging(vector<int>& arr) {
        int n = arr.size();
        vector<int> freq( n+1 , 0 ) ; 
        for( int num : arr ){
            freq[ min(  num , n ) ]++ ; 
        }
        int curr = 1 ; 
        for( int i=2 ; i<=n ; ++i ){
            if( freq[i] > 0 ){
                curr = min( i , curr + freq[i] ) ; 
            }
        }
        return curr; 
    }
};