class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = (int) 1e9 + 7 ; 
        int n = arr.length ; 
        int rs = 0 ; 
        int[] prev = new int[]{1,0} ; 
        int curr = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            curr = ( curr + arr[i] )%2 ;   
            rs = ( rs +  prev[ 1-curr ]) % mod ; 
            prev[curr]++ ;
        }   
        return rs ;
    }
}