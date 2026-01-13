class Solution {
    public int singleNumber(int[] nums) {
        int c=0 ; 
        int n=nums.length ;
        for(int i=0; i<n; i++){
            c=c^nums[i] ;
        }
        return c ;
    }
}