class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder rs = new StringBuilder();
        int[] counts = {a, b, c};
        char[] chars = {'a', 'b', 'c'};

        while (true) {
            int maxIndex = findMaxIndex(counts, -1);
            if (maxIndex == -1) break; 
            if (rs.length() >= 2 && rs.charAt(rs.length() - 1) == chars[maxIndex] 
                && rs.charAt(rs.length() - 2) == chars[maxIndex]) {
                int nextIndex = findMaxIndex(counts, maxIndex);
                if (nextIndex == -1) break;
                rs.append(chars[nextIndex]);
                counts[nextIndex]--;
            } else {
                int useCount = Math.min(2, counts[maxIndex]);
                for (int i = 0; i < useCount; i++) {
                    rs.append(chars[maxIndex]);
                }
                counts[maxIndex] -= useCount;
            }
        }

        return rs.toString();
    }

    private int findMaxIndex(int[] counts, int excludeIndex) {
        int maxIndex = -1, maxCount = 0;
        for (int i = 0; i < counts.length; i++) {
            if (i != excludeIndex && counts[i] > maxCount) {
                maxIndex = i;
                maxCount = counts[i];
            }
        }
        return maxIndex;
    }
}
