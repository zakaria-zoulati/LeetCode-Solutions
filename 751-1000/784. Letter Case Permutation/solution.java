class Solution {
    public List<String> letterCasePermutation(String s) {
        s = s.toUpperCase() ; 
        ArrayList<String> rs = new ArrayList<>() ; 
        int n = s.length() ; 
        int letters = 0 ;  
        boolean[] f = new boolean[n] ; 
        for( int i=0 ; i<n ; ++i ){
           if( s.charAt(i) >= '0' && s.charAt(i) <= '9' ){
                f[i] = true ; 
           }else {
                letters++ ; 
           }
        }
        int total = 1 << letters ; 
        for( int j=0 ; j<total ; ++j ){
            StringBuilder curr = new StringBuilder() ;
            int mask = j ; 
            for(int i=0 ; i<n ; ++i){
                if( f[i] ) {
                    curr.append( s.charAt(i) ) ; 
                    continue ; 
                }else if( mask % 2 == 0 ){
                    curr.append( (char) ( s.charAt(i) + 32 ) ) ; 
                }else{
                    curr.append( s.charAt(i) ) ; 
                }
                mask >>= 1 ;
            }
            rs.add( curr.toString() ) ; 
        }
       return rs ;  
    }
}