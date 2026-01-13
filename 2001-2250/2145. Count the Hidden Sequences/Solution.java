class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int rs = 0 ; 
        int n = differences.length ; 
        long a = Long.MAX_VALUE ; 
        long b = Long.MIN_VALUE ; 
        long prev = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            prev += differences[i] ; 
            a = Math.min( a , prev ) ; 
            b = Math.max( b , prev ) ; 
        }
        if( b - a > upper - lower ) return 0 ; 
        for( int i=lower ; i<=upper ; ++i ){
            if( a + i >= lower && b+i <= upper ) {
                int l = i ;
                int r = upper ;
                while( l < r ){
                    int mid = l + ( r - l + 1 )/2 ; 
                    if( a + mid >= lower && b + mid <= upper ){
                        l = mid ; 
                    }else {
                        r = mid -1 ;
                    }
                }
                return l - i + 1 ; 
            }
        }
        return 0 ; 
    }
}