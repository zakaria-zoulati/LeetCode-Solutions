class Solution {
    public int minSteps(int n) {
        int[] rs = new int[n+1] ;
        rs[1] = 0 ; 
        for(int i=2 ; i<=n ; ++i){
            if( rs[i] == 0 ){
                rs[i] = i ;
            }
            for(int j=2 ; j*i<=n; ++j){
                if( rs[i*j] != 0 ){
                    rs[i*j] = Math.min( rs[i*j] , j + rs[i]  ) ;  
                }else {
                     rs[i*j] = j+ rs[i] ;
                }
            }
            
        }
        return rs[n] ; 
    }
}