class Solution {
    private boolean isGood(int x) {
        boolean valid = false ; 
        while (x > 0) {
            int d = x % 10;
            if (d == 3 || d == 4 || d == 7) return false; 
            if (d == 2 || d == 5 || d == 6 || d == 9) valid = true;
            x /= 10;
        }
        return valid;
    }

    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; ++i) {
            if( isGood( i ) ) count++ ; 
        }
        return count;
    }
}
