class Solution {
    public int numSubmatrixSumTarget(int[][] arr, int target) {
        int n = arr.length ;
        int m = arr[0].length ; 
        int rs = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<m ; ++j ){
                if( i+1 < n ){
                    arr[i+1][j] += arr[i][j] ;
                }
                if( j-1>=0 ){
                    arr[i][j] += arr[i][j-1] ; 
                }
                for( int k=0 ; k<=i ; ++k ){ 
                    for( int t=0 ; t<=j ; ++t ){
                        int diff = ( k-1>=0?arr[k-1][j]:0) +( t-1>=0?arr[i][t-1]:0 ) - ( k-1>=0 && t-1>=0 ? arr[k-1][t-1] : 0 ) ; 
                        if( arr[i][j] - diff == target ){
                            ++rs ; 
                        }
                    }
                }
            }
        }
        return rs ; 
    }
}