class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
      int r = matrix.length, c = matrix[0].length;
      int[][] ps = new int[r + 1][c + 1];
      for (int i = 1; i < r + 1; ++i) {
        for (int j = 1; j < c + 1; ++j) {
          ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + matrix[i - 1][j - 1];
        }
      }
      int rs = 0, curr;
      Map<Integer, Integer> map = new HashMap();
      for (int c1 = 1; c1 < c + 1; ++c1) {
        for (int c2 = c1; c2 < c + 1; ++c2) {
          map.clear();
          map.put(0, 1);
          for (int row = 1; row < r + 1; ++row) {
            curr = ps[row][c2] - ps[row][c1 - 1];
            rs += map.getOrDefault(curr - target, 0);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
          }
        }
      }
      return rs;
    }
  }