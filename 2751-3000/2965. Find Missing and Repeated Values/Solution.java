class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length ; 
        int c = n*n ;
        boolean[] list  = new boolean[c+1] ;
        int sum = 0 ;
        int[] rs = new int[2] ;
        int i=0 ; int j= 0 ;
        for( i=0 ; i<n ; i++){
            for( j=0 ; j<n ; j++){
                sum+=grid[i][j] ;
                if(list[grid[i][j]] == true){
                    rs[0] = grid[i][j] ;
                }
                else {
                    list[grid[i][j]] = true ;
                }   
            }
        }
       
        rs[1] = c*(c+1)/2 - sum + rs[0] ;
        return rs ;



    }
}