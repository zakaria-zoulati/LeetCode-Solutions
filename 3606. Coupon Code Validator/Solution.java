class Solution {
    String[] businessLines = new String[]{
        "electronics" , "grocery" , "pharmacy" , "restaurant"
    };
    boolean isValid( String code , String businessLine ){
        if( code.isEmpty() ) return false ; 
        boolean cdt = false ; 
        for( String t : businessLines ){
            if( t.equals( businessLine ) ){
                cdt = true ;
                break ;  
            }
        }
        if( !cdt ) return false ; 
        for( char c : code.toCharArray() ){
            if( !Character.isLetterOrDigit( c ) && c != '_'  ) {
                return false ; 
            }
        }
        return true ; 
    }
    int value( String s ){
        for( int i=0 ; i<4 ; ++i ){
            if( s.equals( businessLines[i] ) ){
                return i ; 
            }
        }
        return -1 ; 
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length ;   
        List<String[]> coupons = new ArrayList<>() ; 
        for( int i=0 ; i<n ; ++i ){
            if( isActive[i] && isValid( code[i] , businessLine[i] )  ){
                coupons.add( new String[]{ code[i] , businessLine[i] } ) ; 
            }
        }
        Collections.sort( coupons , (a,b) -> {
            if( !a[1].equals(b[1]) ){
                return value( a[1] ) - value( b[1] ) ; 
            }
            return a[0].compareTo( b[0] ) ; 
        }) ; 
        
        List<String> ans = new ArrayList<>() ; 
        for( String[] coupon : coupons ){
            ans.add( coupon[0] ) ; 
        } 

        return ans ; 
    }
}