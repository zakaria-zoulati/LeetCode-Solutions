class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        if( n<=2 ) return true ; 
        int[] nodes = new int[n];
        for (int i = 0; i < n; ++i) {
            if (nodes[i] != 0) continue;
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            nodes[i] = 1; 
            while (!q.isEmpty()) {
                int node = q.poll();
                int currentColor = nodes[node];
                int nextColor = currentColor == 1 ? 2 : 1;
                for (int neighbor : graph[node]) {
                    if (nodes[neighbor] == 0) { 
                        nodes[neighbor] = nextColor; 
                        q.add(neighbor);
                    } else if (nodes[neighbor] != nextColor) { 
                        return false; 
                    }
                }
            }
        }
        return true;
    }
}
