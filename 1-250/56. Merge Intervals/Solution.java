class Solution {
    public int[][] merge(int[][] intervals) {
        int m = -1 ; 
        for( int[] i : intervals ){
            m = Math.max( m , i[1] ) ; 
        }
        int[] start = new int[m+1] ; 
        int[] end = new int[m+1] ; 
        for( int[] i : intervals ){
            start[i[0]]++ ; 
            end[i[1]]++ ; 
        }
        // Counth the number of complete intervals 
        int count = 0 ;
        int curr = 0 ; 
        for( int i=0 ; i<=m ; ){
            while( i<=m && start[i] == 0 ) ++i ; 
            if( i<=m ){
                count++ ; 
                curr = start[i] - end[i] ; 
                i++ ; 
                while( curr > 0 ){
                    curr += start[i] - end[i] ; 
                    i++ ; 
                }
            }
        }
        int[][] rs = new int[count][2] ; 
        // Fill the rs array
        int in = 0 ; 
        for( int i=0 ; i<=m ; ){
            while( i<=m && start[i] == 0 ) ++i ; 
            if( i<=m ){
                rs[in][0] = i ; 
                curr = start[i] - end[i] ; 
                i++ ; 
                while( curr > 0 ){
                    curr += start[i] - end[i] ; 
                    i++ ; 
                }
                rs[in++][1] = i-1 ; 
            }
        }
        return rs ;
    }
}