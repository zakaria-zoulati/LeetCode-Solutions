class Solution {
    public int bestClosingTime(String s) {
        int n = s.length() ; 
        int cu = 0 ; 
        for( char c : s.toCharArray() ){
            if( c == 'Y'){
                cu++ ; 
            } 
        }
        int rs = 0 ; 
        int best = cu ; 
        for(int i=0 ; i<n ;){
            if( s.charAt(i) == 'Y'){
                cu-- ; 
            }else {
                cu++ ; 
            }
            ++i ; 
            if( cu < best ){
                best = cu ; 
                rs = i ; 
            }
        }
        return rs ; 
    }
}