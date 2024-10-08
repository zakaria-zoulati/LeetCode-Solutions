class Solution {
    public int bits( int n ){
        int rs = 0 ; 
        while( n > 0 ){
            n >>= 1 ; 
            rs++ ; 
        }
        return rs  ;
    }
    public int maxGoodNumber(int[] nums) {
        int rs = 0 ; 
        for(int i=0 ; i<3 ; ++i){
            int n1 = nums[ (i+1) % 3 ] ; 
            int n2 = nums[ (i+2) % 3 ] ; 
            int b = bits( n1 )   ; 
            int c = bits( n2 )   ; 
            int curr1 = ( ((nums[i] << b ) + n1 ) << c ) + n2 ; 
            int curr2 = ( ((nums[i] << c ) + n2 ) << b ) + n1 ; 
            rs = Math.max(  rs ,  curr1 ) ; 
            rs = Math.max(  rs ,  curr2 ) ; 
        }
        return rs ; 
    }
}