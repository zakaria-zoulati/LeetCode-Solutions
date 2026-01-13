class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length ; 
        int rs = 0 ; 
        Arrays.sort( nums ) ; 
        int i = 0 ; int j = n-1 ; 
        while( i<j ){
            rs += nums[j--] - nums[i++] ; 
        }
        return rs ; 
    }
}