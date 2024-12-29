class Solution {
    public int numWays(String[] words, String t) {
        int n = t.length();
        int m = words.length;
        int len = words[0].length();
        int mod = 1_000_000_007;
        int[][] f = new int[len][26];
        for(String in : words) {
            for(int i = 0; i < len; ++i) {
                ++f[i][in.charAt(i)-'a'];
            }
        }
        long[] curr = new long[len+1];
        for(int i = 0; i < len+1; ++i) {
            curr[i] = 1;
        }
        long[] next = new long[len+1];
        for(int i = 1; i <= n; ++i) {
            next = new long[len+1] ; 
            for(int j = i; j <= len; ++j) {
                next[j] = (next[j-1] + f[j-1][t.charAt(i-1) - 'a'] * curr[j-1]) % mod;
            }
            curr = next ; 
        }
        return (int) next[len];
    }
}
