class Solution {
    public int concatenatedBinary(int n) {
        int MOD = 1000000007;
        long rs = 0;
        int len = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                len++;
            }
            rs = (( rs << len ) + i) % MOD;
        }
        return (int) rs;
    }
}