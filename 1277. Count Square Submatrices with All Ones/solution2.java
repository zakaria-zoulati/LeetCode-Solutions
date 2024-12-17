class Solution {
    public int countSquares(int[][] arr) {
        int n = arr.length ; 
        int m = arr[0].length ; 
        for( int i=1 ; i<n ; ++i ){
            for( int j=1 ; j<m ; ++j ){
                if(arr[i][j] == 1){
                    arr[i][j] += Math.min(arr[i-1][j-1],Math.min(arr[i-1][j],arr[i][j-1]));
                }
            }
        }
        int rs = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                rs += arr[i][j] ; 
            }
        }
        return rs ; 
    }
}