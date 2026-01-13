class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length() ; 
        int w = 0; 
        int rs = 0 ; 
        for(int i=0 ; i<k ;  ++i){
            if( blocks.charAt(i) == 'W' ) w++ ;
        }
        rs = w ;
        for(int i=k ; i<n ; ++i){
            if( blocks.charAt(i) == 'W' ) w++ ;
            if( blocks.charAt(i-k) == 'W' ) w-- ; 
            rs = Math.min( w , rs ) ;
        }
        return rs  ;
    }
}