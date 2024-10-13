class Solution {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray() ; 
        int i = 0 ; 
        int j = chars.length - 1 ; 
        while( i < j ){
            if( isLetter( chars[i] ) && isLetter( chars[j] ) ){
                swap( i , j , chars ) ; 
                i++ ; 
                j-- ; 
            }else if( !isLetter( chars[i] ) ){
                i++ ; 
            }
            else{
                j-- ; 
            }
        }
        return new String(chars) ; 
    }
    public boolean isLetter( char c ){
        if( ( c >= 'a' && c <= 'z' ) || ( c >= 'A' && c <= 'Z' ) ) return true; 
        return false ; 
    }
    public void swap( int i , int j , char[] arr ){
        char curr = arr[i] ; 
        arr[i] = arr[j] ; 
        arr[j] = curr ; 
    }
}