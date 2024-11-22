class Solution {
    public int numSubmatrixSumTarget(int[][] arr, int target) {
        int n = arr.length, m = arr[0].length;
        int rs = 0;
        for (int[] r : arr ) {
            for (int j = 1; j < m; ++j) {
                r[j] += r[j - 1];
            }
        }
        for (int l = 0; l < m; ++l) {
            for (int right = l; right < m; ++right) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1); 
                int curr = 0;
                for (int r = 0; r < n; ++r) {
                    curr += arr[r][right] - (l > 0 ? arr[r][l - 1] : 0);
                    rs += map.getOrDefault(curr - target, 0);
                    map.put(curr, map.getOrDefault(curr, 0) + 1);
                }
            }
        }
        return rs;
    }
}
