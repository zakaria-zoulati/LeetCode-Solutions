class Solution {
    int n ; 
    int m ; 
    public int maximalSquare(char[][] matrix) {
        n = matrix.length ; 
        m = matrix[0].length ; 
        int rs = 0 ; 
        int[][] sum = new int[n][m] ; 
        for( int i=0 ; i<n ; ++i ){
            if( matrix[i][0] == '1' ){
                sum[i][0] = 1 ; 
            }
            for( int j=1 ; j<m ; ++j ){
                sum[i][j] += sum[i][j-1] ; 
                sum[i][j] += (matrix[i][j] - '0') ; 
            }
        }
        for( int c=0 ; c<m ; ++c ){
            for( int r=0 ; r<n-1; ++r ){
                sum[r+1][c] += sum[r][c] ; 
            }
        }

        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                int left = 0 ; 
                int right = Math.min( i , j ) ; 
                while( left <= right ){
                    int mid = left + ( right - left )/2 ; 
                    if( isPossible( sum , i , j , mid ) ){
                        left = mid  + 1 ; 
                    }else {
                        right  = mid - 1 ; 
                    }
                }
                rs = Math.max( rs , left*left  ) ; 
            }
        }
        return rs ;
    }

    public boolean isPossible( int[][] sum ,int i , int j , int p ){
        if( i-p>=0 && j-p>=0 ){
            int diff = ( j-p>0 ? sum[i][j-p-1] : 0 ) + ( i-p>0 ? sum[i-p-1][j] : 0 ) - ( i-p>0 && j-p>0 ? sum[i-p-1][j-p-1] : 0 ) ; 
            return (sum[i][j] - diff ) == (p+1)*(p+1) ; 
        }
        return false  ; 
    }

}