class Solution {
    int count = 0 ; 
    int curr = 0 ; 
    public void backtrack( int[] nums , int target , int i , int n  ){
        curr += nums[i] ; 
        if( i<n-1 ){
            backtrack( nums , target , i+1 , n ) ;
        }else {
            if( curr == target ){
                count++ ; 
            }
        }
        curr -= 2*nums[i] ; 
        if( i<n-1 ){
            backtrack( nums , target , i+1 , n ) ;
        }else {
             if( curr == target ){
                count++ ; 
            }
        }
        curr += nums[i] ; 
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length ; 
        backtrack( nums , target , 0 , n ) ; 
        return count ; 
    }
}