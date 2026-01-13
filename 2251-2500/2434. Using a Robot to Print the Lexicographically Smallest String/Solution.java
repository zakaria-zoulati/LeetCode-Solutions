class Solution {
    public String robotWithString(String s) {
        int n = s.length() ; 
        char[] chars = s.toCharArray() ; 
        int smallest = 26 ; 
        int[] right = new int[n] ; 
        for( int i=n-1 ; i>=0 ; --i ){
            int curr = chars[i] - 'a' ; 
            if( curr < smallest ){
                smallest = curr ; 
            }
            right[i] = smallest ; 
        }
        StringBuilder rs = new StringBuilder() ;    
        int[] stack = new int[n] ; 
        int in = -1 ; 
        for( int i=0 ; i<n ; ++i ){
            int curr = chars[i] - 'a' ; 
            if( in == -1 ){
                stack[++in] = curr ; 
            }else if( right[i] < stack[in] ){
                if( curr == right[i] ){
                    rs.append( (char) ( 'a' + curr ) ) ; 
                }else {
                    stack[++in] = curr ; 
                }
            }else {
                while( in != -1 && stack[in] <= right[i] ){
                    rs.append( (char) ( 'a' + stack[in--] ) ) ;
                }
                --i ; 
            }
        }
        while( in != -1 ){
            rs.append( (char) ( stack[in--] + 'a' ) ) ; 
        }
        return rs.toString() ; 
    }
}