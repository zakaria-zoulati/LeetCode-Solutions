class Solution {
    int mod = (int) 1e9+7;
    void dfs(ArrayList<int[]>[] edges, int node, int[] rs) {
        for (int[] i : edges[node]) {
            int tar = i[0];
            int w = i[1];
            rs[tar] = (int) ((long) w * rs[node] % mod);
            dfs(edges, tar, rs);
        }
    }
    public int[] baseUnitConversions(int[][] conversions) {
        int n = conversions.length + 1;
        int[] rs = new int[n];
        rs[0] = 1;
        ArrayList<int[]>[] edges = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; ++i) {
            int a = conversions[i][0];
            int b = conversions[i][1];
            int fact = conversions[i][2];
            edges[a].add(new int[]{b, fact});
        }
        dfs(edges, 0, rs);
        return rs;
    }
}
