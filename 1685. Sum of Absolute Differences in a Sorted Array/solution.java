class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length ; 
        int[] rs = new int[n] ; 
        for(int i=1 ; i<n  ; ++i){
            rs[0] += nums[i] - nums[0] ; 
        }
        for(int i=1 ; i<n ; ++i){
            int diff = nums[i] - nums[i-1] ; 
            rs[i] += rs[i-1] - diff + i*diff - ( n-i-1)*diff ; 
        }
        return rs ; 
    }
}