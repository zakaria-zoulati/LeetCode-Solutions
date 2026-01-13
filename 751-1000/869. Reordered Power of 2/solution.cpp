#include <iostream>
#include <vector>

using namespace std ; 

class Solution {
    public:
        bool reorderedPowerOf2(int n) {
            if( n == 1 ) return true ; 
            if( ( n & (n-1) ) == 0  ) return true; 
            vector<int> pows ; 
            vector<int> f( 10 , 0 ) ; 
            int curr = n ; 
            while( curr > 0 ){
                f[curr%10]++ ; 
                curr/=10 ; 
            }
            vector<int> tar( 10 , 0 ) ; 
            for( int i=31 ; i>=0 ; --i ){
                bool fl = true ; 
                int ele = 1 << i ; 
                while( ele > 0 ){
                    tar[ele % 10]++ ; 
                    ele/=10 ; 
                }
                for( int j=0 ; j<10 ; ++j){
                    if( f[j] != tar[j] ){
                        fl = false ;
                    }
                    tar[j]=0 ; 
                }
                if(fl) return true ;
            }
            return false ; 
        }
    };