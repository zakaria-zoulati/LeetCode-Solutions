#include <bits/stdc++.h>

using namespace std ; 

class Solution {
public:
    int countValidPrefixes(string s) {
        int x = 0 , y = 0 ; 
        int ans = 0 ; 
        for( char c : s ){
            if( c == '1' ){
                x++ ; 
            }  else {
                y++ ; 
            }
            if( abs( x - y ) <= 1 ){
                ans++ ; 
            }
        }
        return ans ; 
    }
};