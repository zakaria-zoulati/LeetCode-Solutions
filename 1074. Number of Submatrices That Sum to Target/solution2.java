class Solution {
    public int numSubmatrixSumTarget(int[][] arr, int target) {
        int n = arr.length, m = arr[0].length;
        int rs = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                arr[i][j] += arr[i][j - 1];
            }
        }
        for (int left = 0; left < m; left++) {
            for (int right = left; right < m; right++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1); 
                int curr = 0;
                for (int row = 0; row < n; row++) {
                    curr += arr[row][right] - (left > 0 ? arr[row][left - 1] : 0);
                    rs += map.getOrDefault(curr - target, 0);
                    map.put(curr, map.getOrDefault(curr, 0) + 1);
                }
            }
        }
        return rs;
    }
}
