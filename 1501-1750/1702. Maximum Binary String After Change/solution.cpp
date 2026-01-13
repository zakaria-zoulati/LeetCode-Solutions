class Solution {
public:
    string maximumBinaryString(string s) {
        int n = s.size() ; 
        int prev = -1 ; 
        for( int i=0 ; i<n ; ++i ){
            if( s[i] == '0' ){
                if( prev == -1 ){
                    prev = i ; 
                }else {
                    s[prev] = '1' ; 
                    s[i] = '1' ; 
                    s[prev+1] = '0' ; 
                    prev++ ; 
                }
            }
        }  
        return s ;
    }
};