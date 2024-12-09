class Solution {
    public void setZeroes(int[][] matrix) {
        int n  = matrix.length ; 
        int m = matrix[0].length ; 
        boolean[] rows = new boolean[n] ; 
        boolean[] cols = new boolean[m] ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                if( matrix[i][j] == 0  ){
                    rows[i] = true ; 
                    cols[j] = true ; 
                }
            }
        }   
        for( int i=0 ; i<n ; ++i ){
            if( rows[i] ){
                setRow( matrix , i ) ; 
            }
        }
        for( int i=0 ; i<m ; ++i ){
            if( cols[i] ){
                setCol( matrix , i ) ; 
            }
        }

    }
    public void setRow( int[][] arr , int i  ){
        for( int t=0 ; t<arr[0].length ; ++t ){
                arr[i][t] = 0 ;             
        }
    }
    public void setCol( int[][] arr , int j  ){
        for( int t=0 ; t<arr.length ; ++t ){
                arr[t][j] = 0 ; 
        }
    }
}
