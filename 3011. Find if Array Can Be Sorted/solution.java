class Solution {
    public int bits( Integer n ){
        int rs=0; 
        while(n!=0){
            rs += (n&1) ; 
            n >>=1; 
        }
        return rs ; 
    }
    public boolean canSortArray(int[] nums) {
        int n = nums.length ; 
        int max = -1 ; 
        for( int i=0 ; i<n ; ++i ){
            int b = bits( nums[i] ) ; 
            int mi = nums[i] ; 
            int ma = nums[i] ; 
            while( i+1 <n && bits(nums[i+1])==b ){
                ++i ; 
                mi = Math.min( nums[i] , mi ) ; 
                ma = Math.max( nums[i] , ma ) ;
            }
            if( mi < max ) return false  ; 
            max = ma ; 
        }
        return true ; 
    }
}
