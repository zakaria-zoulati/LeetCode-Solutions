class Solution {
   public long beautifulSubarrays(int[] nums) {
        long res = 0;
        int fre[] = new int[ 2 << 20 ];
        fre[0] = 1;
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            res += (long) fre[xor];
            fre[xor]++;
        }
        return res;
    }
}