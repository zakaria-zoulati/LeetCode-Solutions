class Solution {
    public:
        bool scoreBalance(string s) {
            int tot = 0 ; 
            for( char c : s ){
                tot += ( c - 'a' ) + 1 ; 
            }
            if( tot % 2 == 1 ) return false ; 

            int curr = 0 ; 
            for( char c : s){
                curr += ( c - 'a' ) + 1 ; 
                if( curr == tot/2 ) return true ; 
            } 
            return false ; 
        }
    };