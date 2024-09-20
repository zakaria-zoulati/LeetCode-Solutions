class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length; 
        List<List<Integer>> list = new ArrayList<>();
        if (n < 2) {
            return list;
        }
        int top = 1 << n; 
        Set<Long> seen = new HashSet<>();  
        long[] powers = new long[n];  
        powers[0] = 1;
        for (int i = 1; i < n; i++) {
            powers[i] = powers[i - 1] * 201;
        }
        for (int i = 0; i < top; ++i) {
            List<Integer> curr = new ArrayList<>();
            long hash = 0L;
            int index = 0;
            int prev = -101;
            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) != 0 && nums[j] >= prev) {
                    curr.add(nums[j]);
                    prev = nums[j];
                    hash += (nums[j] + 100) * powers[index];  
                    index++;
                }
            }
            if (curr.size() >= 2 && !seen.contains(hash)) {
                list.add(curr);
                seen.add(hash);
            }
        }
        return list;
    }
}
