class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length() ; 
        int[] rs = new int[n+1] ; 
        int ii = 0 ; 
        int dd = n ; 
        for(int i=0 ; i<n ; ++i){
            if( s.charAt(i) == 'I' ){
                rs[i] = ii++ ; 
            }else {
                rs[i] = dd-- ;
            }
        }
        rs[n] = dd-- ; 
        return rs ; 
    }
}