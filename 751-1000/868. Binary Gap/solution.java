class Solution {
    public int binaryGap(int n) {
        int start = 0 ; 
        int end = 0 ; 
        int rs = 0 ;
        while( n!= 0   ){
            if( (n & 1) == 1 ){
                n >>= 1 ; 
                break ; 
            }
            n >>= 1  ; 
        }
        while(  n != 0  ){
            end++ ; 
            if( (n & 1) == 1 ){
                 rs = Math.max( rs , end-start  ) ; 
                 start = 0 ; 
                 end = 0 ; 
            }
            n >>= 1; 
        }
        return rs ;
    }
}