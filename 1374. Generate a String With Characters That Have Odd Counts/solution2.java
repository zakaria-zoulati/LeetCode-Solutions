class Solution {
    public String generateTheString(int n) {
        char[] chars = new char[n] ; 
        Arrays.fill( chars , 'a' ) ; 
        if( n%2 == 0 ) chars[n-1] = 'b' ; 
        return new String(chars) ; 
    }
}