class Solution {
    class UnionFind {
        int[] parent, rank;
        int count;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        public boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return false;
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootB] < rank[rootA]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
            --count ; 
            return true;
        }
        public int getCount() {
            return count;
        }
    }
    public int minCost(int n, int[][] edges, int k) {
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        UnionFind uf = new UnionFind(n);
        int rs = 0;
        for (int[] e : edges) {
            if (uf.getCount() <= k) break;
            if (uf.union(e[0], e[1])) {
                rs = Math.max(rs, e[2]);
            }
        }
        return rs;
    }
}
