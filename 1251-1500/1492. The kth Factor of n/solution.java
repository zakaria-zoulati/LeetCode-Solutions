class Solution {
    public int kthFactor(int n, int k) {
        if( k==1 ) return 1; 
        int[] arr = new int[n/2+3] ;  
        int curr = 0 ; 
        for(int i=n/2 ; i>=1 ; i--){
            if( n%i == 0 ){
                arr[curr++] = i ;
            }
        }
        if( curr == k-1 ) return n ; 
        if( curr < k ) return -1 ;   
        return arr[ curr - k  ] ; 
    }
}