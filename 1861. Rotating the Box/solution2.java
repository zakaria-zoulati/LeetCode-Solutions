class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length ; 
        int m = box[0].length ; 
        char[][] rs = new char[m][n] ; 
        for( int c=0 ; c<n ; ++c ){ 
            int i = n-1-c; 
            for( int j=m-1 , p = m-1 ; j>=0 ; --j ){
                rs[j][c] = '.' ; 
                if( box[i][j] != '.' ){
                    p = box[i][j] == '#' ? p : j ;  
                    rs[p--][c] = box[i][j] ; 
                }
            }
        }
        return rs ; 
    }
}