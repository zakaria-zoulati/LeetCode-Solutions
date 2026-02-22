class Solution {
public:
    int binaryGap(int n) {
        int ans = 0 ; 
        int prev = -1 ; 
        int curr = 0 ; 
        while( n > 0 ){
            if( n % 2 == 1 ){
                if( prev != -1 ){
                    ans = max( ans , curr - prev ) ; 
                }
                prev = curr ; 
            }
            n >>= 1 ; 
            curr++ ; 
        }
        return ans ;  
    }
};