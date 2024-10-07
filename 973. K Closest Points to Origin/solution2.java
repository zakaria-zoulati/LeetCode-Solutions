class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length ; 
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n ; i++) {
            int[] eucDist = {squaredDistance(points[i]), i};
            if (pq.size() < k) {
                pq.offer(eucDist);
            } else if (eucDist[0] < pq.peek()[0]) {
                pq.poll();
                pq.offer(eucDist);
            }
        }
        int i = 0;
        int[][] answer = new int[k][2];
        for (int[] nearestPoints : pq) {
            answer[i++] = points[nearestPoints[1]];
        }
        return answer;
    }
    private int squaredDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}