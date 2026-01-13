class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int rs = 0;
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int end = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] < end) {
                rs++;
            } else {
                end = interval[1];
            }
        }
        return rs;
    }
}
