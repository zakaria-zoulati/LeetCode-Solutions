class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length() ; 
        StringBuilder rs = new StringBuilder() ; 
        for(int i=0 ; i<n ; ++i){
                int right = 0 ;
                int left = 0 ; 
                left++ ;
                i++  ; 
                while( ( left+right) != 0   ){
                    if( s.charAt(i) == '(' ){
                        left++ ; 
                        rs.append('(') ; 
                    }else {
                        right--; 
                        if(  left + right != 0  ){
                            rs.append(')') ; 
                        }
                    }
                    i++ ; 
                }
                i-- ; 
        }
        return rs.toString() ; 
    }
}