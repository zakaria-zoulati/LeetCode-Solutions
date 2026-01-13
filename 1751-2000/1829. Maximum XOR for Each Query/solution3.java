class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] res=new int[nums.length];
        int mask = ( 1 << maximumBit ) - 1  ;
        int ans=0;
        for(int i:nums) ans^=i;
        for(int i=0;i<nums.length;i++){
            res[i]= mask^ans;
            ans^=nums[nums.length-i-1];
        }
        return res;
    }
}