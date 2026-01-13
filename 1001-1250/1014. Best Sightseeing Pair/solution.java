class Solution {
    public int maxScoreSightseeingPair(int[] arr) {
        int n = arr.length ; 
        int val = arr[0] ; 
        int rs = 0 ; 
        for( int j=1 ; j<n ; ++j ){
            rs = Math.max( arr[j] - j + val , rs ) ; 
            val = Math.max( val , arr[j] + j ) ; 
        }
        return rs ; 
    }
}