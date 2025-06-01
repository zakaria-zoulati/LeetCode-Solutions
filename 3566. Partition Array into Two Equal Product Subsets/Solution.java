class Solution {
    public boolean backtrack( int[] nums , long curr , long other ,  long target ,int i ){
        if( i == nums.length ){
            return curr == target && other == target ; 
        }
        if( curr * nums[i] <= target && target % ( curr * nums[i] ) == 0 ){
            if( backtrack( nums , curr*nums[i] , other ,  target , i+1 ) ) {
                return true ; 
            }
        }
        if( other * nums[i] <= target &&  target % ( other * nums[i] ) == 0 ){
            return backtrack( nums , curr , other*nums[i] ,  target , i+1 ) ; 
        }
        return false ; 
    } 
    public boolean checkEqualPartitions(int[] nums, long target) {
        int n = nums.length ; 
        if( backtrack( nums ,  1L , 1L , target , 0 ) ){
            return true ; 
        }else {
            return false ; 
        }
    }
}