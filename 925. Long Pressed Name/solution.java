class Solution {
    public boolean isLongPressedName(String name, String typed) {
        StringBuilder comp = new StringBuilder() ; 
        int m = typed.length() ; 
        int n = name.length() ; 
        if( n > m ) return false ; 
        int curr = 0 ;
        for(int i=0 ; i<m ; ++i){
           if( curr>=n ) return false ; 
           if( name.charAt(curr) != typed.charAt(i) ) return false ; 
           int a = 1 ; 
           int b = 1 ; 
           while( i+1<m && typed.charAt(i+1) == typed.charAt(i) ){
            i++ ; 
            a++ ; 
           }
           while( curr+1<n && name.charAt(curr) == name.charAt(curr+1) ){
            curr++ ; 
            b++ ;
           }
           curr++ ; 
           if( b > a ) return false ; 
        }
        return curr == n ;
    }
}