public class Solution {
	boolean[][] visited;
	public int minimumEffortPath(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;
		int l = 0;
		int r = 1000001;
		int mid = 0;
		while (l <= r) {
			visited = new boolean[m][n];
			mid = (l + r) >> 1;

			if (helper(heights, 0, 0, mid)) {
				r = mid - 1;
			}
			else {
				l = mid + 1;
			}
		}

		return l;
	}
	public boolean helper(int[][] heights, int x, int y, int mid) {
		int m = heights.length;
		int n = heights[0].length;
		visited[x][y] = true;
		if (x == m - 1 && y == n - 1) {
			return true;
		}
		int t = x + 1;
		if (t < m && !visited[t][y]) {
			if (Math.abs(heights[x][y] - heights[t][y]) <= mid) {
				if (helper(heights, t, y, mid)) {
					return true;
				}
			}
		}
		t = y + 1;
		if (t < n && !visited[x][t]) {
			if (Math.abs(heights[x][y] - heights[x][t]) <= mid) {
				if (helper(heights, x, t, mid)) {
					return true;
				}
			}
		}
		t = x - 1;
		if (t >= 0 && !visited[t][y]) {
			if (Math.abs(heights[x][y] - heights[t][y]) <= mid) {
				if (helper(heights, t, y, mid)) {
					return true;
				}
			}
		}
		t = y - 1;
		if (t >= 0 && !visited[x][t]) {
			if (Math.abs(heights[x][y] - heights[x][t]) <= mid) {
				if (helper(heights, x, t, mid)) {
					return true;
				}
			}
		}
		return false;
	}
}