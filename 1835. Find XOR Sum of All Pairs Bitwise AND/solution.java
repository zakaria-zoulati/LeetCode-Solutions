class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        long n = arr1.length ; 
        long m = arr2.length ; 
        long[] map1 = new long[32] ; 
        long[] map2 = new long[32] ; 
        int rs = 0 ; 

        // Finding all The bits of the arr1
        for( int i=0 ; i<n ; ++i ){
            int curr = 0 ; 
            while( arr1[i] != 0 ){
                if( ( arr1[i] & ( 1 << curr ) ) != 0 ){
                    map1[curr]++ ;
                    arr1[i] -=  ( 1 << curr ) ; 
                }
                curr++ ; 
            }
        }

        // Finding all the bits of The arr2 
        for( int i=0 ; i<m ; ++i ){
            int curr = 0 ; 
            while( arr2[i] != 0 ){
                if( ( arr2[i] & ( 1 << curr ) ) != 0 ){
                    map2[curr]++ ;
                    arr2[i] -=  ( 1 << curr ) ; 
                }
                curr++ ; 
            }
        }

        for( int i=0 ; i<32 ; ++i ){
            long inter = map1[i]*map2[i] ;  
            if( inter % 2 != 0 ){
                rs += ( 1 << i ) ; 
            }
        }

        return rs  ; 
    }
}