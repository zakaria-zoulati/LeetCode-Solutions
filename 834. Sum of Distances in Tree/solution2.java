// Enhanced function 1 dfs is better than 2 
class Solution {
    public int[] getChild(boolean[] isSeen, ArrayList<Integer>[] map, int[] childrens, int curr, int depth) {
        int childCount = 0;
        int distanceSum = 0;
        isSeen[curr] = true;
        for (int neighbor : map[curr]) {
            if (!isSeen[neighbor]) {
                int[] childResult = getChild(isSeen, map, childrens, neighbor, depth + 1);
                childCount += 1 + childResult[0];
                distanceSum += childResult[1] + childResult[0] + 1;
            }
        }
        childrens[curr] = childCount;
        return new int[]{childCount, distanceSum};
    }

    public void call(int curr, int[] childrens, int[] dp, int n, boolean[] isSeen, ArrayList<Integer>[] map) {
        isSeen[curr] = false;
        for (int neighbor : map[curr]) {
            if (isSeen[neighbor]) {
                dp[neighbor] = dp[curr] + n - 2 * (childrens[neighbor] + 1);
                call(neighbor, childrens, dp, n, isSeen, map);
            }
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] dp = new int[n];
        if (n == 1) {
            return dp;
        }

        ArrayList<Integer>[] map = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            map[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }

        int[] childrens = new int[n];
        boolean[] isSeen = new boolean[n];

        dp[0] = getChild(isSeen, map, childrens, 0, 0)[1];
        call(0, childrens, dp, n, isSeen, map);

        return dp;
    }
}
