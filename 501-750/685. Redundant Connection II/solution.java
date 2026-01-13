class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] firstEdge = null, secondEdge = null;
        int[] rootParent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i; 
        }
        // Step 1: Check for a node with two parents
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parent[v] != v) { 
                firstEdge = new int[]{parent[v], v};
                secondEdge = new int[]{u, v};
                edge[1] = -1; 
            } else {
                parent[v] = u;
            }
        }
        // Step 2: Check for a cycle using Union-Find
        for (int i = 1; i <= n; i++) {
            rootParent[i] = i;
        }
        for (int[] edge : edges) {
            if (edge[1] == -1) continue;             
            int u = edge[0], v = edge[1];
            int rootU = find(rootParent, u);
            int rootV = find(rootParent, v);
            if (rootU == rootV) {
                return firstEdge == null ? edge : firstEdge;
            }
            rootParent[rootV] = rootU;
        }
        return secondEdge;
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find( parent , parent[x] ) ; 
        }
        return parent[x] ;  
    }
}