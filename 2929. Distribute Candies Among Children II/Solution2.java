class Solution {
    public long helper(int sum) {
        if (sum < 0) return 0;
        return (long) (sum + 2) * (sum + 1) / 2;
    }
    public long distributeCandies(int n, int limit) {
        long total = helper(n);
        long a = helper(n - (limit + 1));
        long b = helper(n - 2 * (limit + 1));
        long c = helper(n - 3 * (limit + 1));
        return total - 3*a + 3*b - c ; 
    }
}
