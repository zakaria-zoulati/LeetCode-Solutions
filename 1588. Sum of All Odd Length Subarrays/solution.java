class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length ; 
        int rs = 0 ;
        for(int i=1 ; i<n; ++i){
            arr[i] += arr[i-1] ; 
        }
        for(int i=1; i<=n ; i+=2){
            rs += arr[i-1] ; 
            for(int j=i ; j<n ; ++j){
                rs += arr[j] - arr[j-i] ;     
            }
        }
        return rs ;
    }
}