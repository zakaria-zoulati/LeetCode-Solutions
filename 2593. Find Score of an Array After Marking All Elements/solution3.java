class Solution {
    public long findScore(int[] nums) {
        long rs = 0; 
        int n = nums.length;
        boolean[] marked = new boolean[n]; 
        Integer[] a = new Integer[n];
        for(int i = 0; i < n; i++) {
            a[i] = i; 
        }
        Arrays.sort(a, (x, y) -> nums[x] - nums[y] );
        for (int i = 0; i < n; i++) {
            int ind = a[i]; 
            if (marked[ind]) continue;
            rs += nums[ind];
            marked[ind] = true; 
            if (ind > 0) marked[ind - 1] = true; 
            if (ind < n - 1) marked[ind + 1] = true; 
        }
        return rs;
    }
}
