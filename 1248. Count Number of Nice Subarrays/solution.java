class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int rs = 0;
        int co = 0;
        int[] pref = new int[n + 1]; 
        pref[0] = 1; 
        for (int i = 0; i < n; ++i) {
            if (nums[i] % 2 == 1) {
                co++;
            }
            if (co >= k) {
                rs += pref[co - k];
            }
            pref[co]++;
        }
        return rs;
    }
}
