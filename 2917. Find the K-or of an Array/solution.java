class Solution {
    public int findKOr(int[] nums, int k) {
        int rs = 0 ; 
        int[] f = new int[32] ; 
        for(int num : nums ){
            int i=0  ; 
            while( num > 0 ){
                if( (num&1) == 1 ){
                    ++f[i] ; 
                }
                ++i ; 
                num >>= 1 ;
            }
        }
        for( int i=0 ; i<32 ; ++i ){
            if( f[i] >= k ){
                rs += ( 1 << i ) ;  
            }
        }
        return rs ; 
    }
}