class Solution {
    public int maxDistance(String s, int k) {
        int x = 0, y = 0, rs = 0, steps = 0;
        for (char c : s.toCharArray()) {
            if (c == 'E') x++;
            else if (c == 'W') x--;
            else if (c == 'N') y++;
            else y--;
            steps++;
            int currDist = Math.abs(x) + Math.abs(y);
            currDist += 2*Math.min((steps - currDist) >> 1, k); 
            rs = Math.max(rs, currDist);
        }
        return rs;
    }
}
