class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballMap = new HashMap<>();
        Map<Integer, Integer> colorMap = new HashMap<>();
        int[] result = new int[queries.length];
        int index = 0;
        int curr = 0 ;      
        for (int[] query : queries) {
            int ball = query[0];
            int color = query[1];
            if (ballMap.containsKey(ball)) {
                int prevColor = ballMap.get(ball);
                int prevCount = colorMap.get(prevColor);
                colorMap.put(prevColor, prevCount - 1);
                if (prevCount == 1) {
                    curr--;
                }
            }
            ballMap.put(ball, color);
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            if (colorMap.get(color) == 1) {
                curr++;
            }
            result[index++] = curr;
        }
        return result;
    }
}