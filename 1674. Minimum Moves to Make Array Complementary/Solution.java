class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int t = n >> 1;
        int m = 2*limit+2  ;
        int[] diff = new int[m];
        for (int l = 0; l < t; ++l) {
            int r = n - l - 1;
            int a = Math.min(nums[l], nums[r]) + 1;
            int b = Math.max(nums[l], nums[r]) + limit;
            int curr = nums[l] + nums[r];
            diff[2] += 2  ; 
            diff[a]--;
            diff[curr]--;
            diff[curr+1]++;
            diff[b+1]++;
        }
        int rs = diff[2];
        for(int i = 3; i <m-1; ++i) {
            if( ( diff[i] += diff[i-1] ) < rs) rs = diff[i] ; 
        }
        return rs;
    }
}