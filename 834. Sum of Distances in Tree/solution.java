class Solution {
    public int getChild(boolean[] isSeen, ArrayList<Integer>[] map, int[] childrens, int curr) {
        isSeen[curr] = true;
        for (int item : map[curr]) {
            if (!isSeen[item]) {
                childrens[curr] += 1 + getChild(isSeen, map, childrens, item);
            }
        }
        return childrens[curr];
    }

    public int fill(boolean[] isSeen, ArrayList<Integer>[] map, int curr, int d) {
        int rs = 0;
        isSeen[curr] = false;
        for (int item : map[curr]) {
            if (isSeen[item]) {
                rs += d + 1;
                rs += fill(isSeen, map, item, d + 1);
            }
        }
        return rs;
    }

    public void call(int curr, int[] childrens, int[] all, int n, boolean[] isSeen, ArrayList<Integer>[] map) {
        isSeen[curr] = true;
        for (int item : map[curr]) {
            if (!isSeen[item]) {
                all[item] = all[curr] + (n - childrens[item] - 2) - childrens[item];
                call(item, childrens, all, n, isSeen, map);
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

        for (int i = 0; i < n - 1; ++i) {
            map[edges[i][0]].add(edges[i][1]);
            map[edges[i][1]].add(edges[i][0]);
        }

        int[] childrens = new int[n];
        boolean[] isSeen = new boolean[n];
        getChild(isSeen, map, childrens, 0);
        dp[0] = fill(isSeen, map, 0, 0);
        call(0, childrens, dp, n, isSeen, map);
        return dp;
    }
}