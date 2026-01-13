class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder rs = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (x, y) -> y[0] - x[0]
        );
        if (a > 0) pq.add(new int[]{a, 0});
        if (b > 0) pq.add(new int[]{b, 1});
        if (c > 0) pq.add(new int[]{c, 2});
        int prev = -1;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[1] == prev) {
                if (pq.isEmpty()) break;
                int[] next = pq.poll();
                char item = (char) ('a' + next[1]);
                prev = next[1];
                rs.append(item); 
                next[0]-- ; 
                if( next[0] != 0 ){
                    pq.add(next) ; 
                }
                pq.add(curr);
            } else {
                prev = curr[1];
                char item = (char) ('a' + curr[1]);
                if (curr[0] == 1) {
                    rs.append(item); 
                } else {
                    rs.append(item) ;  
                    rs.append(item) ;  
                    curr[0] -= 2;
                    if( curr[0] != 0 ){
                        pq.add(curr);
                    }
                }
            }
        }
        return rs.toString();
    }
}
