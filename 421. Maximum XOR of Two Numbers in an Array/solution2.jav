class Solution {
    Set<Integer> vis = new HashSet<>();
    public int findMaximumXOR(int[] nums) {
        int max = 0, ans = 0, mask = 0, masks = 0;
        for(int num : nums) {
            max = Math.max(max, num);
        }
        int bit = 31;
        while(bit-- >= 0) {
            if((max >> bit & 1) == 1) break;
        }
        for(int i = bit; i >= 0; i--) {
            mask = 1 << i;
            masks |= mask;

            if(check(nums, masks, ans | mask)) {
                ans |= mask;
            }
            vis.clear();
        }
        return ans;
    }
    private boolean check(int[] nums, int masks, int tar) {  
        for(int num : nums) {
            num &= masks;
            if(vis.contains(num ^ tar)) {
                return true;
            }
            vis.add(num);
        }
        return false;
    }
}