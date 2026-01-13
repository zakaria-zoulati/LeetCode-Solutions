class Solution {
    // Solution O(n^2)
    public int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;

        for (int i = 1; i < n - 1; ++i) {
            int lessLeft = 0, greaterLeft = 0, lessRight = 0, greaterRight = 0;
            for (int j = 0; j < i; ++j) {
                if (rating[j] < rating[i]) {
                    lessLeft++;
                } else if (rating[j] > rating[i]) {
                    greaterLeft++;
                }
            }
            for (int j = i + 1; j < n; ++j) {
                if (rating[j] < rating[i]) {
                    lessRight++;
                } else if (rating[j] > rating[i]) {
                    greaterRight++;
                }
            }
            ans += lessLeft * greaterRight + greaterLeft * lessRight;
        }
        return ans;
    }
}
