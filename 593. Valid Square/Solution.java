class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (p1[0] == p2[0] && p1[1] == p2[1] ) {
            return false;
        }
        int[] distances = new int[6];
        int idx = 0;
        distances[idx++] = dist(p1, p2);
        distances[idx++] = dist(p1, p3);
        distances[idx++] = dist(p1, p4);
        distances[idx++] = dist(p2, p3);
        distances[idx++] = dist(p2, p4);
        distances[idx] = dist(p3, p4);
        
        Arrays.sort(distances);
        return distances[0] > 0 && 
               distances[0] == distances[1] && 
               distances[1] == distances[2] && 
               distances[2] == distances[3] && 
               distances[4] == distances[5] && 
               distances[3] < distances[4];
    }
    
    private int dist(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return dx * dx + dy * dy;
    }
}