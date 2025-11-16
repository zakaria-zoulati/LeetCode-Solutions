class Solution {
public:
    int minLengthAfterRemovals(string s) {
        int n = s.length() ; 
        int curr = 0 ; 
        for( char c : s ){
            if( c == 'a' ){
                curr++ ; 
            }else {
                curr-- ; 
            }
        } 
        return abs(curr) ; 
    }
};