class Solution {
    private char change(char a) {
        return a == '0' ? '1' : '0';
    }
    private int ops(String s, char start) {
        int ans = 0;
        for(char c: s.toCharArray()) {
            if(c != start) ans++;
            start = change(start);
        }
        return ans;
    }
    public int minOperations(String s) {
        return Math.min(ops(s, '1'), ops(s, '0'));
    }
}