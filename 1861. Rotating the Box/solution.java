class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length ; 
        int m = box[0].length ; 
        char[][] rs = new char[m][n] ; 
        for( int c=0 ; c<n ; ++c ){
            int p = m-1 ; 
            int i = n-1-c; 
            int e = 0 ; 
            for( int j=m-1 ; j>=0 ; --j ){
                if( box[i][j] == '#' ) e++ ; 
                else if( box[i][j] == '*' ){
                    while( e > 0 ){
                        rs[p--][c] = '#' ; 
                        e-- ; 
                    }
                    while( p != j ){
                        rs[p--][c] = '.' ;  
                    }
                    rs[p--][c] = '*' ; 
                }
            }
            while( e-- > 0 ){
                rs[p--][c] = '#' ;  
            }
            while( p >= 0 ){
                rs[p--][c] = '.' ; 
            }
        }
        return rs ; 
    }
}