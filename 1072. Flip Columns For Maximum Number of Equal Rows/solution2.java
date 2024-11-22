class Solution {
    public int maxEqualRowsAfterFlips(int[][] arr) {
        int m = arr.length ; 
        int n = arr[0].length ; 
        HashMap< String , Integer > map = new HashMap<>() ;
        for( int i=0 ; i<m ; ++i ){
           StringBuilder inter = new StringBuilder() ; 
           boolean flag = true ; 
           if( arr[i][0] == 0 ){
                for( int j=0 ; j<n ; ++j ){
                    inter.append( arr[i][j]) ; 
                }
           }else {
                for( int j=0 ; j<n ; ++j ){
                    inter.append( 1- arr[i][j] ) ; 
                }
           }
           String in = inter.toString() ; 
           map.put( in , map.getOrDefault(in,0) + 1 ) ; 
        }
        
        int rs = 0 ; 
        for( String in : map.keySet() ){
            rs = Math.max( rs , map.get(in) ) ; 
        }
        return rs ; 
    }
}