class Solution {
public:
    int furthestDistanceFromOrigin(string moves) {
        int curr = 0 ; 
        int opt = 0 ; 
        for( int i=0 ; i<moves.size() ; ++i ){
            if( moves[i] == 'L' ){
                curr-- ; 
            }else if( moves[i] == 'R' ){
                curr++ ; 
            }else {
                opt++ ; 
            }
        }       
        return abs(curr) + opt ; 
    }
};