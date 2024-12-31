class Solution {
    public boolean isNumber(String s) {
        int n = s.length() ; 
        int i = 0 ; 
        if( isSign( s.charAt(0) ) ){
            if( n==1 ){
                return false ; 
            }
            i = 1 ; 
        }
        // Check The pattern ( digits . digits )
        int dig = 0  ; 
        while( i<n && isNumber( s.charAt(i) ) ){
            dig++ ; 
            i++ ; 
        } 
        if( i == n ) return true ; 
        if( s.charAt(i) == '.' ){
            i++ ; 
            while( i<n && isNumber( s.charAt(i) ) ){
                ++i ; 
                dig++ ; 
            } 
        }        
        if( dig == 0  ) return false ; 
        if( i == n ) return true ; 
        if( !isExponent( s.charAt(i) ) ){
                return false  ; 
        }
        ++i ; 
        if( i<n &&  isSign( s.charAt(i) ) ){
            ++i ; 
        }
        if( i == n ) return false ;  
        return validTail( s , i , n ) ; 
    }
    public boolean isNumber( char c ){
        return c>='0' && c<='9' ; 
    }
    public boolean isSign( char c ){
        return c == '+' || c == '-' ; 
    }
    public boolean isExponent( char c ){
        return c == 'e' || c == 'E' ; 
    }
    public boolean validTail( String s , int i , int n ){
        for( int j=i; j<n ; ++j ){
            if( !isNumber( s.charAt(j) ) ) return false; 
        }
        return true ;
    }
    
}