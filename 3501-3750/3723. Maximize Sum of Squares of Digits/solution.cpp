#include <bits/stdc++.h>

using namespace std ; 

class Solution {
public:
    string maxSumOfSquares(int num, int sum) {
        if( sum > 9*num ) return "" ; 
        string ans(num,'0') ; 
        int idx = 0 ; 
        while( sum >= 9 ){ 
            ans[idx++] = '9' ; 
            sum -= 9 ; 
        }
        if( sum > 0 ){
            ans[idx] = (char) ( '0' + sum ) ; 
        }
        return ans ; 
    }
};