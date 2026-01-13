#include <vector>
#include <iostream>

using namespace std ; 

class Solution {
    public:
        int mod = 1e9 + 7 ; 
        vector<vector<int>> matrixMult( vector<vector<int>> &A , vector<vector<int>> &B  ){
            vector<vector<int>> RS( 5 , vector<int>(5,0) ) ; 
            for( int i=0 ; i<5 ;++i ){
                for( int j=0 ; j<5 ; ++j ){
                    for(int k=0 ; k<5 ; ++k ){
                        RS[i][j] = ( RS[i][j] + 1LL * A[i][k]*B[k][j] ) % mod ; 
                    }
                }
            }
            return RS ; 
        }
        vector<vector<int>> matrixExp( vector<vector<int>> &A , int n ){
            if( n == 1 ){
                return A ; 
            }
            vector<vector<int>> rs = matrixExp( A , n/2 ) ; 
            rs = matrixMult( rs , rs ) ; 
            if ( n % 2 == 1 ){
                rs = matrixMult( rs , A ) ; 
            }
            return rs ; 
        }
        int countVowelPermutation(int n) {
            if( n == 1 ){
                return 5 ; 
            }
            vector<vector<int>> A(5, vector<int>(5, 0));
            A[1][0] = 1 ;             
            A[0][1] = 1 ; A[2][1] = 1 ;
            A[0][2] = 1 ; A[1][2] = 1 ; A[3][2] = 1 ; A[4][2] = 1 ;
            A[2][3] = 1 ; A[4][3] = 1 ;
            A[0][4] = 1 ;
    
            vector<vector<int>> RS = matrixExp( A , n-1 ) ;
            int rs = 0 ; 
            for( int i=0; i<5 ; ++i ){
                for( int j=0 ; j<5 ; ++j ){
                    rs = ( rs + RS[i][j] ) % mod ; 
                }
            } 
            return rs ; 
        }
    };
    