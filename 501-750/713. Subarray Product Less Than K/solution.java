class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if( k == 0 ) return 0 ; 
        int curr = 1 ;
        int n = nums.length ; 
        int rs = 0 ; 
        int left = 0 ; 
        for(int i=0 ; i<n ; ++i){
            curr *= nums[i] ; 
            if( curr < k ){
                rs += ( i-left+1 ) ; 
            }else {
                while( left<=i && curr >= k ){
                    curr /= nums[left] ; 
                    left++ ; 
                }
                if( curr < k ){
                    rs += i - left +1  ;
                }
            }
        }
        return rs ;
    }
}