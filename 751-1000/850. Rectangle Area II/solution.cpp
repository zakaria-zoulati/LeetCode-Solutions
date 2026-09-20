#include <bits/stdc++.h>


using namespace std ; 
using ll = long long ; 

ll mod = 1e9 + 7 ; 
map<int,ll> mapper1 ; 
map<ll,int> mapper2 ; 

struct SegTree {
    int n ; 
    vector<ll> tag , sum ; 

    SegTree( int n ) : n(n) , tag(4*n) , sum(4*n) {} 

    void pull( int node , int l , int r ){
        if( tag[node] ){
            sum[node] = mapper1[r] - mapper1[l] ; 
        }else if( r - l == 1 ){
            sum[node] = 0 ; 
        }else {
            sum[node] = sum[2*node] + sum[2*node+1] ; 
        }
    } 

    void update( int node , int l , int r , int ql , int qr , int v ){
        if( ql <= l && r <= qr ){
            tag[node] += v ; 
        }else {
            int mid = l + ( r - l )/2 ; 
            int lson = 2*node ; 
            int rson = 2*node+1 ; 
            if( qr <= mid ){
                update( lson , l , mid , ql , qr , v ) ; 
            }else if( mid <= ql ){
                update ( rson , mid , r , ql , qr , v ) ; 
            }else {
                update( lson , l , mid , ql , mid , v ) ; 
                update( rson , mid , r, mid , qr , v ) ; 
            }
        }
        pull( node , l , r ) ; 
    }

    ll query(){
        return sum[1] ; 
    }
};

struct Seg{
    int x1 , x2 , y , v ; 

    bool operator < ( const Seg &seg ) const {
        return y < seg.y ; 
    }
};

class Solution {
public:
    int rectangleArea(vector<vector<int>>& rectangles) {
        int n = rectangles.size() ; 

        // coordinate compression 
        vector<int> vals ; 
        for( int i=0 ; i<n ; ++i ){
            for( int coord : rectangles[i] ){
                vals.push_back(coord); 
            }
        }
        sort( vals.begin() , vals.end() ); 
        int len = 0 ; 
        for( int i=0 ; i<4*n ; ++i ){
            mapper1[len]=vals[i];
            mapper2[vals[i]]=len; 
            while( i+1<4*n && vals[i+1] == vals[i] ){
                i++ ; 
            }
            len++ ; 
        }

        SegTree seg( len ) ; 

        vector<Seg> segs ; 
        for( vector<int> coord : rectangles ){
            segs.push_back( { mapper2[coord[0]] , mapper2[coord[2]] , mapper2[coord[1]] , 1 } );
            segs.push_back( { mapper2[coord[0]] , mapper2[coord[2]] , mapper2[coord[3]] , -1 } );
        }
        sort( segs.begin() , segs.end() ) ; 

        ll ans = 0 ;
        ll prevY = 0 ; 
       
        for( auto [ l , r , y , v ] : segs ){
            ans = ( ans + seg.query() * ( mapper1[y] - prevY ) ) % mod ;
            seg.update( 1 , 0 , len-1 , l , r , v ) ; 
            prevY = mapper1[y] ;  
        }
        return (int) ans ; 
    }
};