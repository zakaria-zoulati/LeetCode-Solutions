class Solution {
    public int xorBeauty(int[] nums) {
        int rs = 0 ; 
        for(int num : nums){
            rs ^= num ; 
        }
        return rs ; 

    }
}