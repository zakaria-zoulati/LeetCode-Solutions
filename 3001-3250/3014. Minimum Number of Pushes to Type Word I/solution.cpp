#include <bits/stdc++.h> 

using namespace std ; 

class Solution {
public:
    int minimumPushes(string word) {
        int n = word.size() ; 

        vector<int> f(26,0) ; 
        for( char c : word ){
            f[ c-'a' ]++ ; 
        }

        int ans = 0 ; 
        int curr = 0 ; 
        int curr_pos = 1 ; 

        sort( f.begin() , f.end() ) ; 
        for( int i=25 ; i>=0 ; --i ){
            if( f[i] > 0 ){
                if( curr == 8 ){
                    curr = 1 ; 
                    curr_pos++ ; 
                }else {
                    curr++ ; 
                }
                ans += curr_pos * f[i] ; 
            }
        }
        
        return ans ; 
    }
};