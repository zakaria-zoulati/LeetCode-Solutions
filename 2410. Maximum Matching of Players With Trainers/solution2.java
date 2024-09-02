class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s); 
        int child = 0, cookie = 0;
        int n = g.length ; 
        int m = s.length ; 
        while (child <n && cookie < m ) {
            if (s[cookie] >= g[child]) {
                child++; 
            }
            cookie++; 
        }
        return child; 
    }
}
