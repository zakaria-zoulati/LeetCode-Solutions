class Solution {
    public int minimizeXor(int num1, int num2) {
        int count = 0 ; 
        while( num2 > 0 ){
            count += num2%2 ; 
            num2 >>= 1 ; 
        }
        int[] rep = new int[32] ; 
        int curr = 0 ; 
        while( num1 > 0 ){
            rep[curr++] = num1%2 ; 
            num1 >>= 1 ; 
        }
        int rs = 0 ; 
        for( int i=31 ; i>=0 && count>0 ; --i ){
            if( rep[i] == 1 ){
                rs += 1<<i ; 
                count-- ; 
            }
        }
        for( int i=0 ; i<32 && count>0 ; ++i ){
            if( rep[i] == 0 ){
                rs += 1<<i ; 
                count-- ; 
            }
        }
        return rs ; 
    }
}