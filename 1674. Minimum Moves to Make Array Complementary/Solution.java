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
            diff[a]--;
            diff[curr]--;
            diff[curr+1]++;
            diff[b+1]++;
        }
        int count = n ; 
        int rs = n;
        for(int i = 2; i <m-1; ++i) {
            count += diff[i] ;
            if( count < rs) rs = count ; 
        }
        return rs;
    }
}