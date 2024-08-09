class NumArray {
    int[] nums;
    int n;
    int[] tree; 

    public void fill(int[] nums, int[] tree) {
        for (int i = 0; i < n; i++) {
           tree[i+1] += nums[i] ;  
           int j  = i+1+lowbit(i+1) ; 
           while( j<=n ){
                tree[j] += nums[i] ; 
                j += lowbit(j) ; 
           }
        }
    }

    public int lowbit(int x) {
        return x & -x;
    }

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[n + 1];
        fill(nums, tree);
    }

    public void update(int index, int val) {
        index++ ;
        int diff = val - (sum( index ) - sum(index-1)) ; 
        while (index <= n) {
            tree[index] += diff  ;
            index += lowbit(index);
        }
    }
    public int sum(int x) {
        int ans = 0;
        while (x > 0) {
            ans += tree[x];
            x -= lowbit(x);
        }
        return ans;
    }
    public int sumRange(int left, int right) {
        return sum(right + 1) - sum(left);
    }
}
