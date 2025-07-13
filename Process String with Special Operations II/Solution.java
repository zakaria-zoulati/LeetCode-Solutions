class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long len = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '#') {
                len *= 2;
            } else if (c == '*') {
                if (len > 0) len--;
            } else if (c == '%') {
            } else {
                len++;
            }
        }
        if (k >= len) return '.';
        k = len - 1 - k ; 
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '#') {
                long half = len / 2;
                if (k >= half) k -= half;
                len = half;
            } else if (c == '%') {
                k = len - 1 - k;
            } else if (c == '*') {
                if( len == 0 ){
                    return '.' ; 
                }  
                len++ ; 
                k++ ; 
                if( k >= len ) return '.' ; 
            } else {
                if (k == 0) return c;
                len--;
                k--; 
            }
        }
        return '.';
    }
}
