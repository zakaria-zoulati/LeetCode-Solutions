class Solution {
    public void fill( int[] nums , int curr ){
        if( curr == 0 ){
            return ; 
        }
        for(int i=0 ; i+1<=curr ; i++ ){
            nums[i] = ( nums[i] + nums[i+1] ) % 10 ; 
        }
        fill( nums , curr-1 ) ; 
    }
    public int triangularSum(int[] nums) {
        fill(  nums , nums.length-1 ) ; 
        return nums[0] ; 

    }
}