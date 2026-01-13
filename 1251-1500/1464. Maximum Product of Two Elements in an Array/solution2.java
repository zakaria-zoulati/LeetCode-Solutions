class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length ; 
        int max1 = nums[0] ;
        int max2 = nums[1] ;
        for(int i=2 ; i<n ; ++i){
            if( nums[i] >= max1 ){
                max2 = Math.max( max1 , max2 ) ; 
                max1 = nums[i] ; 
            }
            else if( nums[i] >= max2 ){
                max2 = nums[i] ; 
            }
        }

        return (max1-1)*(max2-1) ; 
 
    }
}