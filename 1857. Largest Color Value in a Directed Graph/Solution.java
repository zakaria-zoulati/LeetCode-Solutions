class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        char[] ch = colors.toCharArray() ; 
        int n = colors.length();
        List<Integer>[] graph = new List[n];
        int[] inDegree = new int[n] ; 
        for (int i = 0; i < n; ++i) {
            graph[i] = new LinkedList<>();
        }
        for (int[] e : edges) {
            int u = e[0] , v = e[1] ; 
            graph[u].add(v);
            inDegree[v]++ ; 
        }        
        Queue<Integer> q = new LinkedList<>() ; 
        for( int i=0 ; i<n ; ++i ){
            if( inDegree[i] == 0 ){
                q.offer(i) ; 
            }
        }
        int rs = 0 ; 
        int[][] dp = new int[n][26] ;  
        int vis = 0 ; 
        while( !q.isEmpty() ){
            int node = q.poll() , curr = ch[node] - 'a' ;
            ++vis ; 
            rs = Math.max( rs , ++dp[node][curr] ) ; 
            for( int i : graph[node] ) {
                for( int c=0; c<26 ; ++c ){
                    dp[i][c] = Math.max( dp[i][c] , dp[node][c] ) ; 
                }
                if( --inDegree[i] == 0 ){
                    q.offer( i ) ; 
                }
            }
        }
       return vis == n ? rs : -1 ; 
    }
}
