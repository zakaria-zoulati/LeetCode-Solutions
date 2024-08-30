class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if (k == 0) {
            return Arrays.equals(nums1, nums2) ? 0 : -1;
        }

        int n = nums1.length;
        long rs = 0;
        long all = 0;

        for (int i = 0; i < n; ++i) {
            int num1 = nums1[i];
            int num2 = nums2[i];
            int diff = num1 - num2;

            if (diff % k != 0) return -1;

            int a = diff / k;
            rs += a;
            all += (a > 0) ? a : -a; 
        }

        return (rs == 0) ? (all >> 1) : -1; 
    }
}
