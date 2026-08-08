#include <bits/stdc++.h> 

using namespace std ; 

class Solution {
public:
    bool canMakeSubsequence(string &s, string &t) {
        int n = s.size() ; 
        int i=0 , j=0 ; 
        for( auto &ch : t ){
            if( s[j] == ch ) j++ ; 
            if( s[i] == ch ) i++ ; 
            else {
                j = max( j , i+1 ) ; 
            }
            if( i == n || j == n ){
                return true ; 
            }
        }
        return false ; 
    }
};