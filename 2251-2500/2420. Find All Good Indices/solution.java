class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length; 
        List<Integer> rs = new ArrayList<>(); 
        int[] dec = new int[n-k]; 
        int[] inc = new int[n]; 
        dec[0] = 1 ; 
        inc[n-1] = 1; 

        for (int i = 1; i < n-k; ++i) {
            if (nums[i] <= nums[i - 1]) {
                dec[i] = dec[i - 1] + 1;
            } else {
                dec[i] = 1;
            }
        }

        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] <= nums[i + 1]) {
                inc[i] = inc[i + 1] + 1;
            } else {
                inc[i] = 1;
            }
        }

        for (int i = k; i < n - k; ++i) {
            if (dec[i - 1] >= k && inc[i + 1] >= k) {
                rs.add(i);
            }
        }
        return rs; 
    }
}
