class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length ; 
        int[] rs = new int[n] ; 
        int left = 0 ; 
        int right = n-1 ; 
        for(int i=0 ; i<n ; ++i){
            if( nums[i] > 0 ){
                rs[left] = nums[i] ; 
                left += 2 ; 
            }
            if( nums[n-i-1] < 0 ){
                rs[right] = nums[ n-i-1 ] ; 
                right -= 2 ; 
            }
        }  
        return rs ;  
    }
}