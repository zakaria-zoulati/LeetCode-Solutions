class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length ; 
        int left = 0 ; 
        int right = n-1 ; 
        while( left <= right ){
            if( nums[left] == 0  ){
                left++ ; 
            }else if( nums[right] == 2 ){
                right-- ; 
            }else if( nums[left] == 2 || nums[right] == 0 ){
                swap( nums , left , right ) ; 
            }
            else {
                int in = left ; 
                while( in + 1 < right && nums[in] == 1 ){
                    ++in ; 
                }
                if( nums[in] == 1 ) break ; 
                else if( nums[in] == 0 ){
                    swap( nums , left , in ) ; 
                    left++ ; 
                }else{
                    swap( nums , right , in ) ; 
                    right-- ;  
                }
            }
        }
    }
    public void swap( int[] nums , int i , int j ){
        int temp = nums[i] ; 
        nums[i] = nums[j] ; 
        nums[j] = temp ; 
    }
}