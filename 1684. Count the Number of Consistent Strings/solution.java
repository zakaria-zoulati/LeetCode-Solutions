class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] cdt = new boolean[26] ; 
        int len = allowed.length() ; 
        for(int i=0 ; i<len ; ++i){
            cdt[ allowed.charAt(i) - 'a' ] = true ;
        }
        int n = words.length ; 
        int rs = 0 ; 
        ok:for(int i=0 ; i<n ; ++i){
            for(int j=0 ; j < words[i].length() ; ++j ){
                if( !cdt[ words[i].charAt(j) - 'a' ] ) continue ok ;
            }
            rs++;
        }
        return rs ; 
    }
}