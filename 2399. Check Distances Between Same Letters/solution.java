class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int n = s.length() ; 
        boolean isSeen[] = new boolean[26] ; 
        for(int i=0 ; i<n ; ++i){
            if( !isSeen[ s.charAt(i) - 'a' ] ){
                int d = i +  distance[ s.charAt(i) - 'a' ] + 1 ; 
                if( d >= n ||  s.charAt(i) != s.charAt(d) ){
                    return false  ; 
                }
                isSeen[ s.charAt(i) - 'a' ] = true;  
            }
        }
        return true ; 
        
    }
}