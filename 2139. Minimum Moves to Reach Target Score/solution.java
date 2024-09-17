class Solution {
    public int minMoves(int target, int maxDoubles) {
        int x = 1 ; 
        int rs = 0 ;
        while( x < target ){
            if( maxDoubles > 0 ){
                if( target % 2 == 0 ){
                    rs += 1 ; 
                }else {
                    rs += 2 ; 
                }
                target /= 2 ;
                maxDoubles-- ; 
            }else {
                rs += ( target - 1 ) ;
                target = 1  ;   
            }
        }
        return rs; 
    }
}