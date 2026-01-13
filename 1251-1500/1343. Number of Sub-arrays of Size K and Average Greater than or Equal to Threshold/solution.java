class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length ; 
        int curr = 0 ; 
        int rs = 0 ; 
        for( int i=0 ; i<k ; ++i ){
            curr += arr[i] ; 
        }
        if( curr/k >= threshold ){
            rs++ ;
        }

        for( int i=k ; i<n ; ++i ){
            curr += arr[i] - arr[i-k] ;
            if( curr/k >= threshold ){
                rs++ ; 
            }
        }

        return rs ; 
    }
}