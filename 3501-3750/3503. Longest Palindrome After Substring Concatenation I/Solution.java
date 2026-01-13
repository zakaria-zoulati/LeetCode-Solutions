class Solution {
    public boolean check(String s, int i, int j, String t, int a, int b) {
        int len1 = j - i; 
        int len2 = b - a; 
        int len = len1 + len2; 
        int l = 0, r = len - 1;
        while (l < r) {
            char x = (l < len1) ? s.charAt(i + l) : t.charAt(a + (l - len1));
            char y = (r < len1) ? s.charAt(i + r) : t.charAt(a + (r - len1));
            if (x != y) return false;
            l++;
            r--;
        }
        return true;
    }

    public int longestPalindrome(String s, String t) {
        int n = s.length();
        int m = t.length();
        int rs = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                for (int a = 0; a <= m; a++) {
                    for (int b = a; b <= m; b++) {
                        if (check(s, i, j, t, a, b)) {
                            rs = Math.max(rs, (j - i) + (b - a)); 
                        }
                    }
                }
            }
        }
        return rs;
    }
}
