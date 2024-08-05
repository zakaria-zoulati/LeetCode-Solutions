class Solution {
    public boolean validRow( char[][] boards ){
        for(int i=0 ; i<9 ; i++){
            HashSet<Character> set = new HashSet<>() ;
            for(int j=0 ; j<9 ; j++){
                if( boards[i][j] == '.' ) continue ; 
                if( set.contains( boards[i][j] ) ) return false ;
                set.add( boards[i][j] ) ; 
            }
        }
        return true  ; 
    }
     public boolean validCol( char[][] boards ){
        for(int i=0 ; i<9 ; i++){
            HashSet<Character> set = new HashSet<>() ;
            for(int j=0 ; j<9 ; j++){
                if( boards[j][i] == '.' ) continue ; 
                if( set.contains( boards[j][i] ) ) return false ;
                set.add( boards[j][i] ) ; 
            }
        }
        return true  ; 
    }

    public boolean validSub( char[][] board , int i , int j  ){
        HashSet<Character> set = new HashSet<>() ; 
        for(int a=i ; a<i+3 ; a++){
            for(int b= j; b<j+3 ;b++ ){
                if( board[a][b] == '.' ) continue ;
                if( set.contains( board[a][b] ) ) return false ;
                set.add( board[a][b] ) ; 
            }
        }
        return true ; 
    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>() ; 
        for(int i=0 ; i<9 ; i=i+3){
            for(int j=0 ; j<9 ; j=j+3 ){
                if(  !validSub( board , i , j   )  ) return false ; 
            }
        }
        if( validRow( board ) && validCol(board) ){
            return true ; 
        }
        return false ;

    }
}