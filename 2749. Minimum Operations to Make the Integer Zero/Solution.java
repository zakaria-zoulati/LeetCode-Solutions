class Solution {
    boolean helper( long curr , int bits ){
        if( curr < bits ) return false ; 
        int b = 0 ; 
        while( curr > 0 ){
            b++ ; 
            curr -= curr&-curr ; 
        }
        return b <= bits ;
    } 
    public int makeTheIntegerZero(int num1, int num2) {
        if( num2 >= num1 ) return -1 ; 
        for( int i=1 ; i<=32 ; ++i ){
            long curr = num1 - i*1L*num2 ; 
            if( curr < 0 )  return -1 ; 
            if( helper( curr , i ) ){
                return i ; 
            }
        }
       return -1 ; 
    }
}