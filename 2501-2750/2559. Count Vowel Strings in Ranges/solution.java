class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length ; 
        int q = queries.length ; 
        boolean[] chars = new boolean[128] ; 
        String vows = "aeuio" ; 
        for( char c : vows.toCharArray() ){
            chars[c] = true ; 
        }
        int[] rs = new int[q] ; 
        int[] pref = new int[n] ; 
        int f = chars[ words[0].charAt(0) ] && chars[ words[0].charAt( words[0].length() -1 ) ] ? 1 : 0 ; 
        pref[0] = f ; 
        for( int i=1 ; i<n ; ++i ){
            f += chars[ words[i].charAt(0) ] && chars[ words[i].charAt( words[i].length() -1 ) ] ? 1 : 0 ; 
            pref[i] = f ; 
        }
        for( int i=0 ; i<q ; ++i ){
            int l = queries[i][0] ; 
            int r = queries[i][1] ; 
            rs[i] = pref[r] - (l>0 ?pref[l-1]:0) ;  

        }
        return rs ; 
    }
}