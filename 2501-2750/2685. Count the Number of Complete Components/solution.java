class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] isSeen = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (isSeen[i]) continue;
            q.add(i);
            isSeen[i] = true;
            int nodeCount = 0;
            int edgeCount = 0;
            while (!q.isEmpty()) {
                int node = q.poll();
                nodeCount++;
                for (int neighbor : graph[node]) {
                    edgeCount++; 
                    if (!isSeen[neighbor]) {
                        q.add(neighbor);
                        isSeen[neighbor] = true;
                    }
                }
            }
            if (edgeCount == nodeCount * (nodeCount - 1)) {
                result++;
            }
        }
        return result;
    }
}
