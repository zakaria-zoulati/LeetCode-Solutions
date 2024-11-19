class Solution {
    public int longestBeautifulSubstring(String s) {
        int n = s.length() ; 
        int rs = 0 ; 
        String temp = "aeiou" ;
        for( int i=0 ; i<n ; ++i ){
           if( s.charAt(i) == 'a' ){
                int co = 1 ; 
                while( i+1 < n && s.charAt(i+1) == 'a' ){
                    ++i ; 
                    ++co ;
                }
                char c = 'a' ; 
                while( i+1<n && temp.indexOf( s.charAt(i+1) ) == temp.indexOf(c) + 1 ){
                    ++i ; 
                    c = s.charAt(i) ; 
                    ++co ; 
                    while( i+1<n && s.charAt(i+1) == c ){
                        ++co ; 
                        ++i ; 
                    }
                }
                if( c == 'u' ){
                    rs = Math.max( rs , co ) ; 
                }
           }
        }
        return rs ;
    }
}