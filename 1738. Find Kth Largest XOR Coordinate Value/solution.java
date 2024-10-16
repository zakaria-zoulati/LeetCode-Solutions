class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length ; 
        int n = matrix[0].length ; 
        PriorityQueue<Integer> p = new PriorityQueue<>() ; 
        int[][] xor = new int[n][m] ; 
        for( int i=0 ; i<m ; ++i ){
            for( int j=0 ; j<n ; ++j ){
                p.add( matrix[i][j] ) ; 
                if( i+1 <m ) matrix[i+1][j] ^= matrix[i][j] ; 
                if( j+1 <n ) matrix[i][j+1] ^= matrix[i][j] ; 
                if( i+1 <m && j+1<n ){
                    matrix[i+1][j+1] ^= matrix[i][j] ; 
                }
                if( p.size() > k ){
                    p.poll() ; 
                }
            }
        }
        return p.poll() ; 
    }
}