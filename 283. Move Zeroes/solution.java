class Solution {
    public void swap( int[] nums , int i , int j ){
        int temp = nums[i] ; 
        nums[i] = nums[j] ; 
        nums[j] = temp ; 
    }
    public void moveZeroes(int[] nums) {
        int n = nums.length ; 
        int current = 0 ; 
        for(int i=0 ; i<n ; ++i){
            if( nums[i] != 0 ){
                nums[ current++ ] = nums[i] ; 
            }
        }
        for(int i= current ; i<n ; ++i){
            nums[i] = 0 ; 
        }
    }
}