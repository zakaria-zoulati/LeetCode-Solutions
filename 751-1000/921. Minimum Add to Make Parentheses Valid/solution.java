class Solution {
    public int minAddToMakeValid(String s) {
        int left = 0 ; 
        int rs = 0 ; 
        for(char c : s.toCharArray() ){
            if( c == ')' ){
                if( left > 0 ){
                    left-- ; 
                }else {
                    rs++ ; 
                }
            }else {
                left++ ; 
            }
        } 
        rs += left ; 
        return rs ; 

    }
}