#include <bits/stdc++.h> 

using namespace std ; 


class Solution {
public:
    int find( vector<int> &rep , int node ){
        if( rep[node] != node ){
            return rep[node] = find( rep , rep[node] ) ; 
        }
        return rep[node] ; 
    }
    void unite( vector<int> &rep , int a , int b ){
        int r1 = find( rep , a ) ; 
        int r2 = find( rep , b ) ;
        rep[r1] = r2 ; 
    }
    int minimumHammingDistance(vector<int>& source, vector<int>& target, vector<vector<int>>& allowedSwaps) {
        int n = source.size() ; 
        int q = allowedSwaps.size() ; 
        vector<int> rep(n) ;
        for( int i=0 ; i<n ; ++i ){
            rep[i] = i ; 
        } 
        for( int i=0 ; i<q ; ++i ){
            unite( rep , allowedSwaps[i][0] , allowedSwaps[i][1] ) ; 
        } 
        vector<vector<int>> components(n) ; 
        for( int i=0 ; i<n ; ++i ){
            components[ find(rep,i)  ].push_back(i) ; 
        }

        vector<int> freq( 1e5 + 1 , 0 ) ;
        int ans = 0 ; 
        
        for( int i=0 ; i<n ; ++i ){
            for( int idx : components[i] ){
                freq[ source[idx] ]++ ; 
            }
            for( int idx : components[i] ){
                if( freq[ target[idx] ] > 0 ){
                    freq[ target[idx] ]-- ; 
                } else {
                    ans++ ; 
                }
            }
            for( int idx : components[i] ){
                freq[ source[idx] ] = 0 ; 
            }
        }
        return ans ; 
    }
};