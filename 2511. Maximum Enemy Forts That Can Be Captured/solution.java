class Solution {
    public int captureForts(int[] forts) {
        int n = forts.length ; 
        int rs = 0 ; 
        int curr = 0 ; 
        int first = -2 ; 
        for(int i=0; i<n ; ++i){
            if( forts[i] == 0 ) curr++ ;
            else{
                if( first == -2  ){
                    curr = 0 ; 
                    first = forts[i] ; 
                }
                else if( forts[i] == first ){
                    curr = 0 ;
                    continue ; 
                }
                else {
                    first = forts[i] ; 
                    rs = Math.max( rs , curr ) ; 
                    curr = 0 ;  
                }
            }
                
        }
        return rs ;

    }
}