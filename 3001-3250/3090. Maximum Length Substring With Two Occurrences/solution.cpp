#include <bits/stdc++.h>

using namespace std ; 

class Solution {
public:
    int maximumLengthSubstring(string s) {
        int n = s.size() ; 
        vector<int> f(26,0) ; 
        int start = 0 ; 
        int ans = 1 ; 
        for( int i=0 ; i<n ; ++i ){
            int pos = s[i] - 'a' ; 
            if( ++f[ pos ] > 2 ){
                while( f[ pos ] > 2 ){
                    f[ s[start] - 'a' ]-- ; 
                    start++ ; 
                }
            }
            ans = max( ans , i - start + 1 ) ; 
        }
        return ans ; 
    }
};