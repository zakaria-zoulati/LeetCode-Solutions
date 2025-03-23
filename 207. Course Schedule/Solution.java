class Solution {
    public boolean dfs(ArrayList<Integer>[] edges, int[] state, int in) {
        if (state[in] == 1) return false; 
        if (state[in] == 2) return true;  
        state[in] = 1; 
        for (int i : edges[in]) {
            if (!dfs(edges, state, i)) {
                return false;
            }
        }
        state[in] = 2;
        return true;
    }

    public boolean canFinish(int n, int[][] pr) {
        ArrayList<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            edges[i] = new ArrayList<>();
        }
        for (int[] i : pr) {
            edges[i[1]].add(i[0]);
        }
        int[] state = new int[n]; 
        for (int i = 0; i < n; ++i) {
            if (state[i] == 0) {
                if (!dfs(edges, state, i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
