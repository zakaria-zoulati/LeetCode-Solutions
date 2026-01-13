class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder a = new StringBuilder() ;
        StringBuilder b = new StringBuilder() ;
        int n = s.length() ; 
        int m = t.length() ; 
        int cache = 0 ; 
        for(int i = n-1 ; i>=0 ; --i ){
            if( s.charAt(i) == '#' ) cache++ ; 
            else if( cache>0 ) cache-- ; 
            else {
                a.append( s.charAt(i) )  ;
            }
        }
        cache = 0 ; 
        for(int i = m-1 ; i>=0 ; --i ){
            if( t.charAt(i) == '#' ) cache++ ; 
            else if( cache>0 ) cache-- ; 
            else {
                b.append( t.charAt(i) )  ;
            }
        }

        return a.toString().equals( b.toString() ) ; 

    }
}