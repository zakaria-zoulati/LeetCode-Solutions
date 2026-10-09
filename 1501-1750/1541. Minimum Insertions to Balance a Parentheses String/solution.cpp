#include <bits/stdc++.h>

using namespace std ; 

class Solution {
public:
    int minInsertions(string s) {
        int n = s.size() ; 
        int curr = 0 ; 
        int ans = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( s[i] == '(' ){
                curr++ ; 
            }else {
                int count = 1 ; 
                while( i+1<n && s[i+1] == ')' ){
                    count++ ; 
                    i++ ; 
                }
                if( count % 2 == 1 ) {
                    count++ ; 
                    ans++ ; 
                }
                if( count > 2*curr ){
                    ans += ( count - 2*curr )/2 ;  
                    curr = 0 ; 
                }else {
                    curr -= count / 2 ; 
                }
            }
        }
        ans += ( curr << 1 ) ; 
        return ans ; 
    }
};