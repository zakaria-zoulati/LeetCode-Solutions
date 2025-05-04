class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length ; 
        int[][] f = new int[10][10] ; 
        for( int[] i : dominoes ){
            int a = i[0] ; 
            int b = i[1] ; 
            if( b < a ){
                f[b][a]++ ; 
            }else {
                f[a][b]++ ;  
            }
        }
        int rs = 0 ; 
        for( int i=1 ; i<=9 ; ++i ){
            for(int j=1 ; j<=9 ; ++j){
                if( f[i][j] > 1 ){
                    rs += f[i][j]*( f[i][j] - 1 )/2 ; 
                }
            }
        }
        return rs ; 
    }
}