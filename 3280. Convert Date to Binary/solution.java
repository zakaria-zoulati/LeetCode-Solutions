class Solution {
    public StringBuilder transform( String s ){
        StringBuilder rs = new StringBuilder() ; 
        int n = Integer.parseInt( s ) ; 
        while( n != 0 ){
            rs.append( n%2 ) ; 
            n >>= 1  ;
        }
        return rs.reverse() ;
    }
    public String convertDateToBinary(String date) {
        String[] rs = date.split( "-" ) ; 
        StringBuilder sb = new StringBuilder() ; 
        for( String s : rs ){
            sb.append( transform( s ) ) ;
            sb.append('-') ; 
        }
        String f = sb.toString() ; 
        return f.substring( 0, f.length() -1 ) ; 

    }
}