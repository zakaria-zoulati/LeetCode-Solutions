class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length ; 
        int rs = 0 ; 
        Arrays.sort( nums ) ; 
        int mid = nums[n/2] ; 
        for(int num : nums){
            rs += Math.abs( num - mid ) ; 
        }
        return  rs ; 
    }
}