class Solution {
    public int maxBalancedShipments(int[] arr) {
        int n = arr.length ; 
        int rs = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            int b = 0 ; 
            while( i+1<n && arr[i+1] >= arr[i] ) {
                 i++ ; 
            }
            if( i+1<n && arr[i+1 ] < arr[i]  ) {
                i++ ; 
                rs++ ; 
            }
        }
        return rs ; 
    }
}