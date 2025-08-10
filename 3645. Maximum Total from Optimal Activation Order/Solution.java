class Solution {
    public long maxTotal(int[] value, int[] limit) {
        int n = value.length ; 
        long rs = 0 ; 
        int[][] m = new int[n][2] ; 
        for( int i=0 ; i<n ; ++i ){
            m[i][0] =  limit[i] ; 
            m[i][1] =  value[i] ; 
        }
        Arrays.sort( m , (a,b) -> {
            if( a[0] != b[0] ){
                return a[0] - b[0] ; 
            }
            return b[1] - a[1] ; 
        }) ; 
        int p = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            int start = i ; 
            int curr = m[i][0] ; 
            int count = 1 ; 
            while( i+1 <n && m[i+1][0] == m[i][0] ){
                count++ ; 
                i++ ; 
            }
            for( int j=start ; j<start+Math.min(curr,count) ; ++j ){
                rs += m[j][1] ; 
            }
        }
        return rs ; 
    }
}