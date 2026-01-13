class Solution {
    public void fill( int[] nums , int curr ){
        if( curr == 1 ){
            return ; 
        }
        for(int i=0 ; i<curr/2; ++i){
            if( i%2 == 0 ){
                nums[i] = Math.min( nums[2*i] , nums[2*i+1] ) ; 
            }else {
                nums[i] = Math.max( nums[2*i] , nums[2*i+1] ) ; 
            }
        }
        fill( nums , curr/2 ) ;
    }
    public int minMaxGame(int[] nums) {
        fill( nums , nums.length ) ; 
        return nums[0] ; 
    }
}