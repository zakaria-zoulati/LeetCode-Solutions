class Solution {
    public boolean backtrack( String pattern , char[] chars , boolean[] isUsed , int i ){
        if( i == pattern.length() + 1 ){
            return true ; 
        }
        for( char c = '1' ; c<='9' ; c += 1 ){
            if( isUsed[ c - '0' ] ) continue ;
            if( pattern.charAt(i-1) == 'I' ){
                if( chars[i-1] < c ){
                    isUsed[ c - '0' ] = true ; 
                    chars[i] = c ; 
                    if(backtrack( pattern , chars , isUsed , i+1 )){
                        return true ;
                    }
                    isUsed[ c - '0' ] = false ;
                }
            }else if(  chars[i-1] > c ){
                    isUsed[ c - '0' ] = true ; 
                    chars[i] = c ; 
                    if(backtrack( pattern , chars , isUsed , i+1 )){
                        return true ;
                    }
                    isUsed[ c - '0' ] = false  ;
            }
        }
        return false ; 
    }
    public String smallestNumber(String pattern) {
        int n = pattern.length() ; 
        char[] chars = new char[n+1] ; 
        boolean[] isUsed = new boolean[10] ; 
        for( char c = '1' ; c<='9' ; c += 1 ){
            isUsed[ c - '0' ] = true ;
            chars[0] = c ; 
            if( backtrack( pattern , chars , isUsed , 1 ) ){
                return new String( chars ) ;
            }
            isUsed[ c - '0' ] = false ; 
        }
        return new String( chars ) ; 
    }
}