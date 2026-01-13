class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length() ; 
        int rs = 0 ; 
        int zeros = 0 ; 
        int ones = 0 ; 
        for(int i=0 ; i<n ; ++i){
            if( s.charAt(i) == '1' ){
                ones++ ; 
                while( i+1<n && s.charAt(i+1) == '1' ){
                    ones++ ; 
                    i++ ; 
                }
                if( ones >= zeros ) rs += zeros ; 
                else rs += ones ; 
                zeros = 0 ; 
            }else {
                zeros++ ; ;
                while( i+1<n && s.charAt(i+1) == '0' ){
                    zeros++ ; 
                    i++ ; 
                }
                if( ones >= zeros ) rs += zeros ; 
                else rs += ones ; 
                ones = 0 ; 
            }
        }

        return rs ; 

    }
}