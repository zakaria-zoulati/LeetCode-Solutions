class Solution {
    public String compressedString(String s) {
        int n = s.length() ; 
        StringBuilder rs = new StringBuilder() ; 
        for(int i=0 ; i<n ; ++i){
            char c = s.charAt(i) ; 
            int co = 1 ; 
            while(i+1<n && s.charAt(i+1) == c && co<9 ){
                ++co ; 
                ++i ; 
            }
            rs.append(co) ; 
            rs.append(c) ;
        }
        return rs.toString() ; 
    }
}