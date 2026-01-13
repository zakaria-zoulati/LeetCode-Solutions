class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        for (int i = 0; i < sum.length; i++) {
            res += map.getOrDefault(sum[i] - k, 0);
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return res;
    }
}