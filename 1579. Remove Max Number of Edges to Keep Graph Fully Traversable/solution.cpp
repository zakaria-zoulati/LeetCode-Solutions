#include <iostream>
#include <vector>

using namespace std ; 

class Solution {
    public:
        int find( vector<int> &rep , int node ){
            if( rep[node] != node ){
                rep[node] = find( rep , rep[node] ); 
            }
            return rep[node] ; 
        }
        void unite( vector<int> &rep , int a , int b ){
            int r1 = find( rep , a ) ; 
            int r2 = find( rep , b ) ; 
            if( r1 != r2 ){
                rep[r1] = r2 ; 
            }
        }
        int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
            int m = edges.size(); 
            if( m < n-1 ) return -1 ; 
            int ans = 0 ; 
            vector<int> rep( n+1 ) ; 
            for( int i=1 ; i<=n ; ++i ){
                rep[i] = i ; 
            } 
            for( int i=0 ; i<m ; ++i ){ 
                if( edges[i][0] == 3 ){
                    int u = edges[i][1] ; 
                    int v = edges[i][2] ;
                    int r1 = find( rep , u ) ; 
                    int r2 = find( rep , v ) ; 
                    if( r1 == r2 ) {
                        ans++ ;
                    }else {
                        unite( rep , u , v ) ; 
                    }
                }
            }
            vector<int> rep_alice( n+1 ) ;  
            vector<int> rep_bob( n+1 ) ; 
            for( int i=1 ; i<=n ; ++i ){
                rep_alice[i] = rep[i] ; 
                rep_bob[i] = rep[i] ; 
            }
            for( int i=0 ; i<m ; ++i ){
                int t = edges[i][0] ; 
                if( t == 1 ){
                    int u = edges[i][1] ; 
                    int v = edges[i][2] ;
                    int r1 = find( rep_alice , u ) ; 
                    int r2 = find( rep_alice , v ) ; 
                    if( r1 == r2 ) {
                        ans++ ;
                    }else {
                        unite( rep_alice , u , v ) ; 
                    }
                }else if( t == 2 ){
                    int u = edges[i][1] ; 
                    int v = edges[i][2] ;
                    int r1 = find( rep_bob , u ) ; 
                    int r2 = find( rep_bob , v ) ; 
                    if( r1 == r2 ) {
                        ans++ ;
                    }else {
                        unite( rep_bob , u , v ) ; 
                    }
                }
            }
            int r_alice = find( rep_alice , 1 ) ; 
            int r_bob = find( rep_bob , 1 ) ; 
            for( int i=2 ; i<=n ; ++i ){
                if( r_alice != find( rep_alice , i ) ) return -1 ; 
                if( r_bob != find( rep_bob , i ) ) return -1 ; 
            }
            return ans ; 
        }
    };