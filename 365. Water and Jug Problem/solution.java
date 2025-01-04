class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        int mi = Math.min(x,y) ; 
        int ma = Math.max(x,y) ; 
        int total = ma + mi ; 
        if( target > ma + mi ){
            return false ; 
        }
        if( target % mi == 0 ){
            return true ; 
        }
        // so the target = k*mi + r
        int r = target % mi ; 
        int rest = ma % mi ; 
        
        while( rest != 0 ){
            if( rest == r ) return true ; 
            rest = ( ma - ( mi - rest ) )%mi ; 
        }; 
        return false ; 
    }
}