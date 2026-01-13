class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int n = mat.length ; 
        int m = mat[0].length ;
        int[] rs = new int[2] ; 
        for(int i=0 ; i<n ; ++i){
            int current = 0 ;
            for(int j=0 ; j<m ; ++j){
                current += mat[i][j] ; 
            }
            if( current > rs[1] ){
                rs[0] = i ;
                rs[1] = current ;
            }
        }
        return rs ; 
    }
}