class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long rs = 0L ; 
        int neg = 0 ; 
        int low = Integer.MAX_VALUE ; 
        for( int[] r : matrix ){
            for( int i : r ){
                if( i<0 ){
                    ++neg ; 
                    rs -= i ; 
                    low = Math.min( low , -i ) ;
                }else {
                    low = Math.min( low , i  ) ;
                    rs += i ;
                }
            }
        }
        if( neg % 2 == 1 ){
            rs -= 2*low ;
        }
        return rs ; 
    }
}