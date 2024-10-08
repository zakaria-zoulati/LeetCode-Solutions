class Solution {
    private static final long MOD = 1000000007L;
    public int concatenatedBinary(int n) {
        int curr = 0;
        long ans = 0;
        for (int i = 1; i <= n; ++i) {
            if ((1<<curr) == i) ++curr;
            ans = ((ans << curr) + i)%MOD;
        }
        return (int) ans;
    }
}