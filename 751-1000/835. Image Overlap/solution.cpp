#include <bits/stdc++.h>
#define vvi vector<vector<int>> 

using namespace std; 

class Solution {
public:
    int check( vvi &img1 , vvi &img2 , int n , int x , int y ){
        int ans = 0 ;
        int start_x = max( 0 , -x ) , end_x = min( n-1 , n-1 - x ) ;  
        int start_y = max( 0 , -y ) , end_y = min( n-1 , n-1 - y )  ; 
        for( int i=start_x ; i<=end_x ; ++i ){
            for( int j=start_y ; j<=end_y ; ++j ){
                if( img2[i][j] == 0 ) continue ;  
                ans += img1[i+x][j+y];
            }
        }
        return ans ; 
    }

    int largestOverlap(vvi& img1, vvi& img2) {
        int n = img1.size(); 
        int ans = 0 ; 
        
        for( int i=-n+1 ; i<n ; ++i ){
            for( int j=-n+1 ; j<n ; ++j ){
                ans = max( ans , check( img1 , img2 , n , i , j ) ) ; 
            }
        }
        return ans ; 
    }
};