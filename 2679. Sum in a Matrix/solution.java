class Solution {
    public int matrixSum(int[][] nums) {
        int n = nums.length ; 
        int m = nums[0].length ; 
        int rs = 0 ; 
        int[][] data = new int[n][1001] ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                data[i][ nums[i][j] ]++ ; 
            }
        }
        int[] p = new int[n] ; 
        for( int i=0 ; i<n ; ++i ){
            p[i] = 1000 ;
        }
        while( m-- > 0 ){
            int ele = 0 ; 
            for( int i=0 ; i<n ; ++i ){
                while( data[i][ p[i] ] == 0 ){
                    p[i]-- ; 
                }
                ele = Math.max( ele , p[i] ) ; 
                if( data[i][ p[i] ]-- == 1 ){
                    p[i]-- ; 
                }
            }  
            rs += ele ; 
        }
        return rs ; 
    }
}