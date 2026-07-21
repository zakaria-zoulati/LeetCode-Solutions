#include <bits/stdc++.h>

using namespace std ; 

class Solution {
public:
    int maxActiveSectionsAfterTrade(string s) {
        int n = s.size() ; 
        int ones = 0;
        int best = 0 ;
        int prev = 0 ;
        for( int i=0 ; i<n ; ++i ){
            if( s[i] == '1' ){
                ones++ ; 
            }else {
                int curr = 1 ; 
                while( i+1<n && s[i+1] == '0' ){
                    curr++ ; i++ ; 
                }
                if( prev == 0 ){
                    prev = curr ; 
                }else {
                    best = max( best , prev + ( prev = curr ) ) ; 
                }
            }
        }
        return ones + best ; 
    }
};