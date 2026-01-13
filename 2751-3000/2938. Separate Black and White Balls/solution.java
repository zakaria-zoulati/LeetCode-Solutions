class Solution {
    public long minimumSteps(String s) {
        long rs = 0L ; 
        int n = s.length() ; 
        int ones = 0 ; 
        for(int i=0 ; i<n ; ++i){
            if( s.charAt(i) == '1' ){
                ones++ ; 
            }else {
                rs += ones ; 
            }
        }
        return rs ; 
    }
}