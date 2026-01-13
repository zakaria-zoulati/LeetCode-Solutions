#include <iostream>
#include <vector>
#include <algorithm>

using namespace std ; 

class Solution {
    public:
        int maxXorSubsequences(vector<int>& nums) {
            vector<int> basis  ; 
            for( int a : nums ){
                int A = a ; 
                for( int b : basis ){
                     A = min( A , A^b ) ;        
                }
                if( A ){
                    basis.push_back(A) ; 
                }
            }
            int rs = 0 ;
            sort( basis.rbegin() , basis.rend() ) ; 
            for( int i : basis ){
                rs = max( rs , rs^i ) ;  
            }
            return rs ; 
        }
    };