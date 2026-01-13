class Solution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[32];
        for (int i : nums) {
            int c = 0 ; 
            while( i != 0 ){
                sum[c++] += i%2 ; 
                i >>= 1 ; 
            }
        }
        long rs = 0;
        for (int e : nums) {
            long curr = (long) e << k ;
            for (int i = 0; i < 32; ++i) {
                if ((e & (1 << i)) != 0) {
                    if (sum[i] > 1) {
                        curr |= (1L << i);
                    }
                } else if (sum[i] > 0) {
                    curr |= (1L << i);
                }
            }
            rs = Math.max(rs, curr);
        }
        return rs;
    }
}
