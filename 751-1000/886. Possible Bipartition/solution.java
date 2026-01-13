class Solution {
    boolean response = true ;
    public void dfs(int e, boolean[] isSeen, HashSet<Integer>[] sets, int ind,  ArrayList<Integer>[] map) {
        if (!response || isSeen[e]) return;
        isSeen[e] = true;
        sets[ind].add(e);
        for (Integer h : map[e]) {
            if(sets[ind].contains(h)) {
                response = false;
                return;
            }
            if(!isSeen[h]) {
                dfs(h, isSeen, sets, (ind + 1) % 2, map); 
            }
        }
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if(n==1)return true;
        boolean[] isSeen = new boolean[n+1];
        ArrayList<Integer>[] map = new ArrayList[n+1] ; 
        for(int i=1; i<=n; ++i) {
            map[i] = new ArrayList<>() ; 
        }
        for(int[] d:dislikes) {
            map[ d[0] ].add(d[1]);
            map[ d[1] ].add(d[0]);
        }
        HashSet<Integer>[] sets = new HashSet[2];
        sets[0] = new HashSet<>();
        sets[1] = new HashSet<>();
        for (int i=1; i<=n ;++i) {
            if (!isSeen[i]) {
                dfs(i, isSeen, sets, 0, map);
            }
        }
        return response;
    }
}
