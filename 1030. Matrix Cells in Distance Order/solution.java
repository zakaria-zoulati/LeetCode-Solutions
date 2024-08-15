import java.util.*;

class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int len = rows * cols;
        int[][] rs = new int[len][];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter) - Math.abs(b[0] - rCenter) - Math.abs(b[1] - cCenter)
        );

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                pq.add(new int[]{i, j});
            }
        }
        for (int i = 0; i < len; ++i) {
            rs[i] = pq.poll();
        }
        return rs;
    }
}
