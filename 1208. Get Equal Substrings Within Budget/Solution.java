class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length() ; 
        int[] costs = new int[n] ; 
        for( int i=0 ; i<n ; ++i ){
            costs[i] = Math.abs( s.charAt(i) - t.charAt(i) ) ; 
        }
        int rs = 0 ; 
        int start = 0 ; 
        int curr = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            curr += costs[i] ; 
            while( curr > maxCost ){
                 curr -= costs[ start++ ] ; 
            }
            rs = Math.max( rs , i - start + 1 ) ;
        }
        return rs ;
    }
}