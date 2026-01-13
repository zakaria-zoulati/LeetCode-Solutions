class Solution {
    char[] chars ; 
    boolean valid( String s , int i ){
        if( i - 2 >= 0 && chars[i-2] != ' ' ){
            return false ; 
        }
        if( chars[i] >= '1' && chars[i] <= '9' ){
            while( i+1<s.length() && chars[i+1] != ' ' ){
                i++ ; 
                if( chars[i] < '0' || chars[i] > '9' ){
                    return false  ; 
                }
            }
            return true ; 
        }
        return false ; 
    }
    public String discountPrices(String sentence, int discount) {
        int n = sentence.length() ; 
        this.chars = sentence.toCharArray() ; 
        StringBuilder rs = new StringBuilder() ; 
        for( int i=0 ; i<n ; ++i ){
            if( sentence.charAt(i) == '$' ){
                rs.append( chars[i] ) ; 
                i++;  
                if( i<n && valid( sentence , i ) ){
                    double curr = 0 ; 
                    while( i<n && chars[i] != ' ' ){
                        curr = ( curr*10 + ( chars[i] - '0' ) ) ; 
                        i++ ; 
                    }
                    double per = ( (double) 100 - discount )/100 ; 
                    curr *= per ; 
                    rs.append(String.format("%.2f", curr));
                    if( i<n ){
                        rs.append( ' ' ) ; 
                    }
                }else {
                    while( i<n && chars[i] != ' ' ){
                        rs.append( chars[i] ) ; 
                        i++ ; 
                    }
                    if( i<n  ){
                         rs.append( ' ' ) ; 
                    }
                }
            }else {
                rs.append( chars[i] ) ; 
            }
        }
        return rs.toString() ; 
    }
}