class Solution2 {
    public int numberOfArrays(int[] diff, int lower, int upper) {
        int n = diff.length ; 
        int a = Integer.MAX_VALUE ; 
        int b = Integer.MIN_VALUE ; 
        int prev = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            prev += diff[i] ; 
            a = Math.min( a , prev ) ; 
            b = Math.max( b , prev ) ; 
        }
        if( b - a > upper - lower ) return 0 ; 
        if( lower + a >= lower ){
            if( lower + b  > upper ) return 0 ; 
            return upper - lower - b  + 1  ;  
        }else if( upper + a < lower ){
            return 0 ; 
        }else {
            int start = lower ; 
            int end = upper ; 
            while( start < end ){
                int mid = start + (end-start)/2 ; 
                if( a + mid >= lower ){
                    end = mid ; 
                }else {
                    start = mid + 1 ; 
                }
            }
            if( start + b > upper ) return 0 ; 
            return  Math.min( upper - start , ( upper - ( start + b ) ) ) + 1 ;
        }
    }
}