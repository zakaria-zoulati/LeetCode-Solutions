class Solution {
    public int maxAbsoluteSum(int[] a) {
        int s = 0, mi = 0, ma = 0;
        for (int num : a) {
            s += num;
            ma = Math.max(ma, s);
            mi = Math.min(mi, s);
        }
        return Math.abs(ma - mi);
    }
}
