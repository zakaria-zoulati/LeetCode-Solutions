#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <set>

using namespace std ; 

class Solution {
    public:
        int distinctPoints(string s, int k) {
            int n = s.size() ; 
            int x = 0 , y = 0 ; 
            set<pair<int,int>> ss ; 
            for( int i=0 ; i<k ; ++i ){
                if( s[i] == 'U' ){
                   y++ ; 
                }else if( s[i] == 'D' ){
                    y-- ; 
                }else if( s[i] == 'R' ){
                    x++ ; 
                }else {
                    x-- ; 
                }
            }
            ss.insert( {x,y} ); 
            for( int i=k; i<n ; ++i ){
                if( s[i] == 'U' ){
                   y++ ; 
                }else if( s[i] == 'D' ){
                    y-- ; 
                }else if( s[i] == 'R' ){
                    x++ ; 
                }else {
                    x-- ; 
                }
                
                if( s[i-k] == 'U' ){
                   y-- ; 
                }else if( s[i-k] == 'D' ){
                    y++ ; 
                }else if( s[i-k] == 'R' ){
                    x-- ; 
                }else {
                    x++ ; 
                }
                ss.insert( {x,y} ) ; 
            }
            return ss.size() ; 
        }
    };