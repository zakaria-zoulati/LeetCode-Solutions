class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
         int n = arr.length ;  
         long cost1 = 0L ; 
         for(int i=0 ; i<n ; ++i){
             cost1 += Math.abs( arr[i] - brr[i] ) ; 
         }         
         long cost2 = k ; 
         Arrays.sort(arr) ; 
         Arrays.sort(brr) ; 
         for( int i=0 ; i<n ; ++i ){
             cost2 += Math.abs( arr[i] - brr[i] ) ; 
         }
         return Math.min( cost1 , cost2 ) ; 
    }
}