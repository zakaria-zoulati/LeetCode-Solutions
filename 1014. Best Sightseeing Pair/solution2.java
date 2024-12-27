class Solution {
    public int maxScoreSightseeingPair(int[] arr) {
        int n = arr.length ; 
        int val = arr[0] ; 
        int rs = 0 ; 
        for( int j=1 ; j<n ; ++j ){
            int curr = arr[j] - j + val ;
            if( curr > rs ){
                rs = curr ; 
            } 
            if( arr[j] + j > val ){
                val = arr[j] + j ;  
            }
        }
        return rs ; 
    }
}