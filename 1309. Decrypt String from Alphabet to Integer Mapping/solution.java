class Solution {
    public String freqAlphabets(String s) {
        StringBuilder rs = new StringBuilder(); 
        int n = s.length(); 
        for (int i = 0; i < n; ++i) {
            if (i + 2 < n && s.charAt(i + 2) == '#') {
                int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0'); 
                rs.append((char) (num - 1 + 'a')); 
                i += 2; 
            } else {
                rs.append((char) (s.charAt(i) - '1' + 'a'));
            }
        }
        return rs.toString(); 
    }
}
