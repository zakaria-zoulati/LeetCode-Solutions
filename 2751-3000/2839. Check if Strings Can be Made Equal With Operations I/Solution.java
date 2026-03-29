class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] chars1 = s1.toCharArray() ; 
        char[] chars2 = s2.toCharArray() ; 

        if( chars1[0] == chars2[0] ) {
            if( chars1[2] != chars2[2] ) return false ; 
        }else if( chars1[2] != chars2[0] || chars1[0] != chars2[2] ){
            return false ; 
        }

        if( chars1[1] == chars2[1] ) {
            if( chars1[3] != chars2[3] ) return false ; 
        }else if( chars1[3] != chars2[1] || chars1[1] != chars2[3] ){
            return false ; 
        }

        return true ; 
    }
}