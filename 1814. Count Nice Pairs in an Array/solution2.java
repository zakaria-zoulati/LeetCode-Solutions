class Solution {
    int mod = (int) 1e9 + 7;
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int rs = 0;
        for (int i = 0; i < n; ++i) {
            int revNum = 0, original = nums[i];
            while (original > 0) {
                revNum = revNum * 10 + original % 10;
                original /= 10;
            }
            int inter = nums[i] - revNum;
            int count = map.getOrDefault(inter, 0);
            rs = (rs + count) % mod;
            map.put(inter, count + 1);
        }
        return rs;
    }
}
