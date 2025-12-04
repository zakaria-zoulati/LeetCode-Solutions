class Solution {
public:
    int countCollisions(string d) {
        int ans = 0 ; 
        int flag = -1 ; 
        for( char c : d ){
            if( c == 'L' ){
                if( flag >= 0 ){
                    ans += flag + 1 ;
                    flag = 0 ; 
                }
            }else if( c == 'S' ){
                if( flag > 0 ) ans += flag ; 
                flag = 0 ; 
            }else {
                if( flag >= 0  ) flag++ ; 
                else flag = 1 ; 
            }
        } 
        return ans ; 
    }
};