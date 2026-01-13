class Solution {
    public int minImpossibleOR(int[] nums) {
        int mask = 0 ;  
        for( int i : nums ){
            if( (i & (i-1)) == 0 ){
                mask |= i ; 
            }
        } 
        int i=0 ; 
        while( mask > 0 ){
            if( (mask&1) == 0 ){
                return 1 << i ; 
            }
            mask >>= 1 ; 
            ++i ; 
        }
        return 1 << i;
    }
}