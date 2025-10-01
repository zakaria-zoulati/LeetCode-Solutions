class Solution {
    public:
        int numWaterBottles(int numBottles, int numExchange) {
            int a = numBottles ; 
            int b = 0 ;
            int rs = 0 ;  
            while( a+b >= numExchange ){
                rs += a ; 
                int temp = a + b ; 
                a = temp/numExchange ; 
                b = temp%numExchange ; 
            }
            rs += a ; 
            return rs ;
        }
    };