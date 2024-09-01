class Solution {
    public int count(int in) {
        int rs = 0;
        while (in != 0) {
            rs += in % 10;
            in /= 10;
        }
        return rs;
    }
    public int countBalls(int lowLimit, int highLimit) {
        int[] counts = new int[46];
        for (int i = lowLimit; i <= highLimit; ++i) {
            counts[count(i)]++;
        }
        int max = 0;
        for (int count : counts) {
            max = Math.max(max, count);
        }

        return max;
    }
}