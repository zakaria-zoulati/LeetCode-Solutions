class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int rs = 0;
        int curr = 0;
        int[] map = new int[32];
        Arrays.fill(map, -1);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') curr ^= 1;
            else if (c == 'e') curr ^= 2;
            else if (c == 'i') curr ^= 4;
            else if (c == 'o') curr ^= 8;
            else if (c == 'u') curr ^= 16;
            if ( curr == 0 ) {
                rs = i+1 ; 
            } else if( map[curr] == -1 ){
                map[curr] = i ; 
            }
            else {
                rs = Math.max(rs, i  - map[curr]);
            }
        }
        return rs;
    }
}
