class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length ; 
        boolean[] seen1 = new boolean[n] ; 
        boolean[] seen2 = new boolean[n] ; 
        int rs = n ; 
        while( ( node1 != -1 || node2 != -1 )  && rs == n ){
            if( node1 != -1 ){
                seen1[node1] = true ; 
                if( seen2[node1]){
                    rs = Math.min( rs , node1 ) ; 
                }else if(  edges[node1] == -1 || seen1[ edges[node1] ] ) {
                    node1 = -1 ;
                }else {
                    node1 = edges[node1] ; 
                }
            }
            if( node2 != -1 ){
                seen2[node2] = true ; 
                if( seen1[node2]){
                    rs = Math.min( rs , node2 ) ; 
                }else if( edges[node2] == -1 || seen2[ edges[node2] ] ) {
                    node2 = -1 ;
                }else {
                    node2 = edges[node2] ; 
                }
            }
        }
        return rs == n ? -1 : rs ; 
    }
}