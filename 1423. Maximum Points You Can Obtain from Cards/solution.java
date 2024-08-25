class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;

        for (int i = 0; i < k; i++) {
            total += cardPoints[i];
        }

        int maxScore = total;

        for (int i = 0; i < k; i++) {
            total = total - cardPoints[k - 1 - i] + cardPoints[n - 1 - i];
            maxScore = Math.max(maxScore, total);
        }
        return maxScore;
    }
}
