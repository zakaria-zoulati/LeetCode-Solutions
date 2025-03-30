class Solution {
    public boolean check( String s , int i , int j , String t , int a , int b ){
        StringBuilder curr = new StringBuilder() ; 
        curr.append( s.substring(i,j) ) ; 
        curr.append( t.substring(a,b) ) ;
        int len = curr.length() ; 
        int l = 0 ; 
        int r = len-1 ; 
        while( l < r ){
            if( curr.charAt(l) != curr.charAt(r) ) return false ; 
            l++; 
            r-- ; 
        }
        return true ; 
    }
    public int longestPalindrome(String s, String t) {
        int n = s.length() ; 
        int m = t.length() ; 
        int rs = 1 ; 
        for( int i=0 ; i<=n ; ++i ){
            for( int j=i ; j<=n ; ++j ){
                for( int a=0 ; a<=m ; ++a ){
                    for( int b=a ; b<=m ; ++b ){
                        if( check( s , i , j , t , a , b ) ){
                            rs = Math.max( rs , j-i + b-a ) ; 
                        }
                    }
                }
            }
        }
        return rs ;
    }
}