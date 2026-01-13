class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length ; 
        int[] rs = new int[n] ; 
        for(int i=0 ; i<n ; ++i){
            rs[i] = nums[ nums[i] ] ; 
        }
        return rs ; 
    }
}