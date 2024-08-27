class Solution {
    public int maxProductDifference(int[] nums) {
        int n  = nums.length ;
        int min1 = nums[0]  ; 
        int min2 = nums[1] ; 
        int max1 = nums[0] ; 
        int max2 = nums[1] ;
        for(int i=2 ; i<n ; ++i ){
            if( nums[i] < min1 ){
                if( min1 < min2 ){
                    min2 = min1 ; 
                }
                min1 = nums[i] ; 
            }else if( nums[i] < min2 ){
                min2 = nums[i] ; 
            }

            if( max1 < nums[i] ){
                if( max2 < max1 ){
                    max2 = max1 ;
                }
                max1 = nums[i] ; 
            }else if( max2 < nums[i] ){
                max2 = nums[i] ; 
            } 
        }
        int rs =  max1*max2 - min1*min2 ; 
        return rs ; 
    }
}