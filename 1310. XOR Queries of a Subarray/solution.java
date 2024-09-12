class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length ; 
        int m = queries.length ; 
        int[] rs = new int[m] ; 
        for(int i=1 ; i<n ; ++i){
            arr[i] ^= arr[i-1] ; 
        }
        for(int i=0 ; i<m ; ++i){
            if( queries[i][0] == 0 ){
                rs[i] = arr[ queries[i][1] ] ; 
            }else {
                rs[i] = arr[ queries[i][1] ] ^ arr[ queries[i][0] - 1 ] ; 
            }
        }
        return rs ; 
    }
}