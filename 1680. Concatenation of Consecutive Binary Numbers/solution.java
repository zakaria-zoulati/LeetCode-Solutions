class Solution {
    int mod = ( (int) 1e9 ) + 7 ; 
    public int bits( int n ){
        int rs = 0 ; 
        while( n>0 ){
            rs++ ; 
            n >>= 1; 
        }
        return rs ; 
    }
    public int concatenatedBinary(int n) {
        long curr = 0L ; 
        for(int i=1 ; i<=n ; ++i){
            int b = bits(i) ; 
            curr = (( curr << b ) + i ) % mod ; 
        }
        return (int) curr ; 
    }
}