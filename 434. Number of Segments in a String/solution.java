class Solution {
    public int countSegments(String s) {
        int n = s.length() ; 
        int rs = 0 ; 
        boolean flag = true ; 
        for(int i=0 ; i<n ; ++i){
            if( flag && s.charAt(i) != ' ' ){
                flag = false ; 
                rs++ ; 
            }else  if( s.charAt(i) == ' ' )  {
                flag = true ; 
            }else {

            }
        }
        return rs ; 
    }
}