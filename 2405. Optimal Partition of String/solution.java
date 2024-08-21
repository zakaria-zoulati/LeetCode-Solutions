class Solution {
    public int partitionString(String s) {
        int ans = 1, mask = 0;
        for (char c : s.toCharArray()) {
            int a = 1 << (c - 'a');
            if ((mask & a) == a) {
                ans++;
                mask = a;
            } else mask |= a;
        }
        return ans;
    }
}