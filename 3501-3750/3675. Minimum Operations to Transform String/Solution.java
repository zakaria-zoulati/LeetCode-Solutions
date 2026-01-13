class Solution {
    public int minOperations(String s) {
        int[] f = new int[26] ; 
        int n = s.length() ; 
        for( char c : s.toCharArray() ){
            f[c-'a']++ ; 
        }
        int rs = 0 ; 
        for( int i=1 ; i<26 ; ++i ){
            rs += f[i]>0?1:0 ; 
            if( i+1<26 ) f[i+1]+=f[i] ;
        }
        return rs ; 
    }
}