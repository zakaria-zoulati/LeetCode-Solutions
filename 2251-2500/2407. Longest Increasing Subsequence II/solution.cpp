#include <bits/stdc++.h>


using namespace std; 

struct SegTree {
    int n ; 
    vector<int> seg ; 

    SegTree(int n) : n(n) , seg(4*n) {}

    int maxRange(int l, int r){
        l = max( l , 1 ) ; 
        r = min( r , n-1 ) ; 
        return maxRange( 1 , 1 , n-1 , l , r ) ; 
    }

    int maxRange(int node , int lo , int hi , int l , int r){
        if( r < lo || hi < l ){
            return 0 ; 
        }

        if( l <= lo && hi <= r ){
            return seg[node] ; 
        }

        int mid = lo + ( hi - lo )/2 ; 
        return max( 
            maxRange( 2*node , lo , mid , l , r ),
            maxRange( 2*node+1 , mid+1 , hi , l , r )
        );
    }

    void update( int k , int v ){
       update( 1 , 1 , n-1 , k , v );
    }

    void update(int node, int lo, int hi, int k , int v ){
        if( lo == hi ){
            seg[node] = v ; 
            return ; 
        }
        int mid = lo + (hi - lo )/2 ; 
        if( k <= mid ){
            update( 2*node , lo , mid , k , v );
        }else {
            update( 2*node+1, mid+1 , hi , k , v );
        }
        seg[node] = max( seg[2*node] , seg[2*node+1] ); 
    }
};

class Solution {
public:
    int lengthOfLIS(vector<int>& nums, int k) {
        ios::sync_with_stdio(false);
        cin.tie(nullptr);

        int ans = 1 ; 
        
        int m = 1 ; 
        for( int num : nums ){
            m = max( m , num ) ; 
        }
        
        SegTree seg( m + 1 ) ; 

        for( int num : nums ){
            if( num == 1 ){
                seg.update( 1 , 1 );
            }else {
                int prev = seg.maxRange( num - k , num - 1 ) ; 
                ans = max( ans , prev + 1 ) ; 
                seg.update( num , prev + 1 ) ; 
            }
        }
        return ans ; 
    }
};