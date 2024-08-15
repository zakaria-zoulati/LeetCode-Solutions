class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int len = rows * cols;
        int[][] rs = new int[len][];

        int[][] directions  = new int[][]{ {0,-1} , {-1,0} , {1,0} , {0,1} } ; 
        Queue< int[] > q = new LinkedList<>() ;
        boolean[][] seen = new boolean[rows][cols] ; 
        q.add(  new int[]{ rCenter , cCenter}  ) ; 
        seen[rCenter][cCenter] = true ; 
        int i = 0 ; 
        while( !q.isEmpty() ){
            int[] curr = q.remove() ; 
            rs[i++] = curr ; 
            for(int[] d : directions  ){
                int r = curr[0] + d[0] ; 
                int c = curr[1] + d[1] ; 
                if( r>=0 && r<rows && c>=0 && c<cols && !seen[r][c] ){
                    seen[r][c] = true ; 
                    q.add(  new int[]{r,c} ) ; 
                }
            }
        }
        return rs ; 
    }
}
