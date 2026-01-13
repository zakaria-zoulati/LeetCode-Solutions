class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = n - 1;
        int j = m - 1;
        int c1 = 0; 
        int c2 = 0; 

        while (i >= 0 || j >= 0) {
            while (i >= 0 && (s.charAt(i) == '#' || c1 > 0)) {
                if (s.charAt(i) == '#') {
                    c1++;
                } else {
                    c1--;
                }
                i--;
            }
            while (j >= 0 && (t.charAt(j) == '#' || c2 > 0)) {
                if (t.charAt(j) == '#') {
                    c2++;
                } else {
                    c2--;
                }
                j--;
            }
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }

            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--;
            j--;
        }

        return true;
    }
}
