#include <bits/stdc++.h>

using namespace std ; 

class Solution {
public:
    bool judgeSquareSum(int c) {
        if( c <= 2 ) return true ; 
        int m = sqrt(c) ; 
        if( m * m == c ) return true ; 
        int l = 1 , r = m ; 
        while( l <= r ){
            int x = l*l ; 
            int y = c - r*r ; 
            if( x == y ) return true ; 
            if( x > y ){
                r--;  
            }else {
                l++ ; 
            }
        }
        return false; 
    }
};