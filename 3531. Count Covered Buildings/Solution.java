class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int m = buildings.length ; 

        int[] maxRow = new int[n+1] ; 
        int[] minRow = new int[n+1] ; 
        int[] maxCol = new int[n+1] ; 
        int[] minCol = new int[n+1] ; 

        Arrays.fill( minRow , n+1 ) ; 
        Arrays.fill( minCol , n+1 ) ; 

        for( int[] b : buildings ){
            int x = b[0] ; 
            int y = b[1] ; 
            minRow[x] = Math.min( minRow[x] , y ) ; 
            maxRow[x] = Math.max( maxRow[x] , y ) ; 
            minCol[y] = Math.min( minCol[y] , x ) ; 
            maxCol[y] = Math.max( maxCol[y] , x ) ;    
        }

        int ans = 0 ; 
        for( int[] b : buildings ){
            int x = b[0] ; 
            int y = b[1] ; 
            if( minRow[x] < y && y < maxRow[x] && minCol[y] < x && x < maxCol[y] ){
                ans++ ; 
            }
        }
        return ans ;
    }
}