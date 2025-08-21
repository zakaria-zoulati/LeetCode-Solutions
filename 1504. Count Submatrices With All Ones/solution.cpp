#include <vector>
#include <iostream>

using namespace std ; 

class Solution {
    public:
        int numSubmat(vector<vector<int>>& mat) {
            int n = mat.size() ; 
            int m = mat[0].size() ; 
            vector<int> height( m , 0 ) ; 
            int rs = 0 ; 
            for( int i=0 ; i<n ; ++i ){
                for( int j=0 ; j<m ; ++j ){
                    if( mat[i][j] == 0 ){
                        height[j] = 0 ;
                    }else {
                        height[j]++ ; 
                    }
                }
                for( int j=0 ; j<m ; ++j ){
                    if( height[j] == 0 ) continue ; 
                    int min_h = height[j] ; 
                    for( int k=j ; k<m && min_h>0 ; k++ ){
                        min_h = min( min_h , height[k] ) ; 
                        rs += min_h ; 
                    }
                }
            }
            return rs ;     
        }
    };