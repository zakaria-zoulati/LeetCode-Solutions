class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length() ; 
        char[] chars = s.toCharArray() ;
        int[] diff = new int[n+1] ;
        diff[0] = chars[0] - 'a' ; 
        for( int i = 1 ; i<n ; ++i ){
            diff[i] = chars[i] - chars[i-1] ; 
        } 
        for( int[] q : shifts ){
            int l = q[0] ; 
            int r = q[1] ; 
            int in = q[2]==1?1:-1 ; 
            diff[l] += in ; 
            diff[r+1] -= in ; 
        }
        int dec = 10_000*26 ; 
        // Rebuild The diffrence array after construction 
        chars[0] = (char) ( 'a' + ( diff[0] + dec )%26 ) ; 
        for( int i=1 ; i<n ; ++i ){
            diff[i] += diff[i-1] ; 
            chars[i] = (char) ( 'a' + ( diff[i] + dec )%26 ) ; 
        }
        return new String(chars) ;
    }
}