class Solution {
    public:
        int maxBottlesDrunk(int n, int m) {
            int a = n ; 
            int b = 0 ; 
            int rs = 0;  
            while( true ){
                rs += a ; 
                b += a ; 
                a = 0 ; 
                if( b >= m ){
                    a++ ; 
                    b -= m ; 
                    m++ ; 
                }else {
                    break ; 
                }
            }
            rs += a ; 
            return rs ; 
        }
    };