class Solution {
    public boolean stoneGameIX(int[] stones) {
        int n = stones.length ; 
        int[] m = new int[3] ;
        for( int i : stones ){
            ++m[i%3] ; 
        }
        if( m[1] == 0 && m[2] == 0 ){
            return false  ; 
        }
        int curr = 0 ; 
        if( m[1] > 0 ){  
            curr = Math.min( m[1]-1 , m[2] ) ; 
            if( m[1] - curr > 2 && m[0] % 2 == 1 ){
                return true ; 
            }else if( m[2] > curr && m[0] % 2 == 0 ) {
                return true ; 
            }
        }
        if( m[2] > 0 ){
            curr = Math.min( m[2] - 1 , m[1] ) ; 
            if( m[1] == curr && m[2] - curr == 1 ){
                return false ; 
            }else if( m[2] - curr > 2 && m[0] % 2 == 1){
                    return true ; 
            }else if ( m[1] > curr && m[0] % 2 == 0  ) {
                    return true ; 
            }
        }
        return false  ;
    }
}