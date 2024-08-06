class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length ; 
        int inter = 0;
        int min = Integer.MAX_VALUE ; 
        for(int i=0 ; i<n ; i++){
            inter = nums[i] ; 
            if( inter >=k ){
                return 1 ; 
            }
            for(int j=i ; j<n ; j++){
                inter |= nums[j] ; 
                if( inter >= k ){
                    min = Math.min(min ,  j-i+1 ) ;
                }
            }
        }
        if( min == Integer.MAX_VALUE ) return -1 ; 
        return min ;

    }
}