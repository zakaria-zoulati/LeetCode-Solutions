class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length() ; 
        boolean[][] dp = new boolean[26][26] ; 
        for( int i=0 ; i<n ; ++i ){
            int a = s1.charAt(i) - 'a' ; 
            int b = s2.charAt(i) - 'a' ;
            dp[a][b] = true ;  
            dp[b][a] = true ;  
        }
        // Handle the strongly connected components 
        char[] chars = new char[26]  ; 
        boolean isSeen[] = new boolean[26] ; 
        for( int i=0 ; i<26 ; ++i ){
            if( !isSeen[i] ){
                dfs( i , i , isSeen , dp , chars ) ; 
            } 
        }
        StringBuilder rs = new StringBuilder() ; 
        for( char c : baseStr.toCharArray() ){
           rs.append( chars[ c-'a']) ; 
        }
        return rs.toString() ; 
    }
    public void dfs( int i , int curr , boolean[] isSeen , boolean[][] dp , char[] chars ){
            isSeen[curr] = true ; 
            chars[ curr ] = (char) ( 'a' + i ) ; 
            for( int j=0 ; j<26 ; ++j ){
                if( dp[curr][j] && !isSeen[j] ){
                    dfs( i , j , isSeen , dp , chars ) ; 
                }
            }
    }
}