class Solution {
    public int  compute( String s ){
        int rs = 0 ; 
        for(int i=0 ; i<s.length() ;++i){
            rs += s.charAt(i) - '0' ; 
        }
        return rs ;
    }
    public String digitSum(String s, int k) {
        int n = s.length() ; 
        if( n <= k ){
            return s  ; 
        }
        StringBuilder rs = new StringBuilder() ; 
        for(int i=0 ; i<n ; i += k ){
            if( i+k <=n  ){
                rs.append( compute(s.substring(i,i+k)) ) ; 
            }else {
                rs.append(  compute(s.substring( i , n )) ) ; 
            }
        }
        if( rs.toString().length() <= k ){
            return rs.toString() ; 
        }
        return digitSum( rs.toString() , k ) ; 
    }
}