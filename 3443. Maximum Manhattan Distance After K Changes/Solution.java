class Solution {
    public int maxDistance(String s, int k) {
        int x = 0 ; 
        int y = 0 ; 
        int man_y = 0; 
        int man_x = 0 ; 
        int rs = 0 ; 
        for( char c : s.toCharArray()){
            if( c == 'E' ){
                ++x ; 
                ++man_x ; 
            }else if( c == 'W' ){
                --x ;
                ++man_x ; 
            }else if( c == 'N' ){
                ++y ; 
                ++man_y ; 
            }else {
                --y ; 
                ++man_y ; 
            }
            int curr = Math.abs(x) + Math.abs(y) ; 
            int moves = (man_x + man_y - curr )/2 ; 
            curr += 2*Math.min( moves , k ) ; 
            if( curr > rs ){
                rs = curr ; 
            }
        }
        return rs ; 
    }
}