class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length ; 
        if( arr[n-1] == n ){
            return n+k ; 
        }
        int inter = arr[n-1] - n ; 
        if( inter < k  ){
            return arr[n-1] + (k-inter) ; 
        }
        int rs = 0 ;
        int current = 1;  
        while( k>0){
            int pos = Arrays.binarySearch( arr , current ) ; 
            if( pos < 0 ) {
                k-- ; 
                rs = current ;
            }
            current++; 
        }
        return rs ; 
    }
}