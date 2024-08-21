class Solution {
    // More efficient no queue use only recursion 
    private boolean isBipartititeUtil(int[][] graph, int curr, int[] color) {
        if (color[curr] == -1) {
            color[curr] = 0; 
        }
        for (int i = 0; i < graph[curr].length; i++) {
            int neighbour = graph[curr][i];
            
            if (color[neighbour] != -1 && color[curr] == color[neighbour]) {
                return false; 
            } 
            else if (color[neighbour] == -1) { 
                color[neighbour] = (color[curr] == 0) ? 1 : 0;
                
                if (!isBipartititeUtil(graph, neighbour, color)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1; 
        }
        
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) { 
                if (!isBipartititeUtil(graph, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}