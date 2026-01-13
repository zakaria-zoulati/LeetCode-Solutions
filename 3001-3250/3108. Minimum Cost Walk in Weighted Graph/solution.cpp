#include <iostream>
#include <vector>

using namespace std ; 

class Solution {
    public:
        void unite( int a , int b , vector<int> &rep , vector<int> &m ){
            int x = find(rep[a] , rep ) ; 
            int y = find(rep[b] , rep) ; 
            if( x != y ){
                rep[y] = x ; 
                m[x] &= m[y] ; 
            }
        }
        int find( int node , vector<int> &rep ){
            if( node != rep[node] ){
                rep[node] = find( rep[node] , rep ) ; 
            }
            return rep[node] ; 
        } 
        vector<int> minimumCost(int n, vector<vector<int>>& edges, vector<vector<int>>& query) {
            vector<int> rep( n ) ; 
            for( int i=0 ; i<n ; ++i ){
                rep[i] = i ; 
            }
            vector<int> m( n , INT_MAX ) ; 
            for( vector<int> &e : edges ){
                int u = e[0] ; 
                int v = e[1] ; 
                int c = e[2] ; 
                unite( u , v , rep , m ) ; 
                m[ find( u , rep )] &= c ; 
            }
            int q = query.size() ; 
            vector<int> rs(q,-1) ; 
            for( int i=0 ; i<q ; ++i ){
                int u  = find( query[i][0] , rep) ; 
                int v  = find( query[i][1] , rep ) ;
                if( u == v ){
                    rs[i] = m[ u ] ; 
                }
            }
            return rs ; 
        }
    };