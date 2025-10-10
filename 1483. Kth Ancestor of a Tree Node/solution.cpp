#include <iostream> 
#include <vector>

using namespace std ; 

class TreeAncestor {
    public:
        vector<vector<int>> up ;
        vector<int> logs ; 
        void pre(int d){
            logs.assign( d+1 , 0 ) ; 
            for( int i=2 ; i<=d ; ++i ){
                logs[i] = logs[ i >> 1 ] + 1 ; 
            } 
        }
        TreeAncestor(int n, vector<int>& parent) {
            pre(n) ; 
            int k = logs[n] ;     
            up.assign( n , vector<int>( k+1 , -1 ) ) ; 
            for( int i=0 ;i<n ; ++i ){
                up[i][0] = parent[i] ; 
            }
            for( int i=1 ; i<=k ; ++i ){
                for( int j=1 ; j<n ; ++j ){
                    if( up[j][i-1] != -1 ){
                        up[j][i] = up[ up[j][i-1] ][i-1] ; 
                    }
                }
            }
        }
        int getKthAncestor(int node, int k) {
            while( k > 0 ){
                int p = logs[k] ; 
                if( up[node][p] == -1 ) return -1 ; 
                node = up[node][p] ; 
                k -= ( 1 << p ) ; 
            }
            return node ; 
        }
    };
    