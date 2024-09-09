class Solution {
public:
    int minChanges(int n, int k) {
        int count = 0 ; 
        int rs = 0 ; 
        while( k != 0 ){
            if( k%2 == 1 ){
                if( ( n & ( 1 << count ) ) == 0 ){
                    return -1 ;
                }
                
            }else {
                if( (  n & (  1 << count  ) ) != 0  ){
                    rs++ ;
                }
            }
            n -=  n & ( 1 << count ) ; 
            k >>= 1 ; 
            count++  ; 
        }
        return rs + __builtin_popcount( n ) ; 
    }
};