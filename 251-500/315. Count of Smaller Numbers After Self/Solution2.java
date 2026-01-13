class Solution {
    public void sort(int[][] pairs, int l, int r, List<Integer> rs) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(pairs, l, m, rs);
            sort(pairs, m + 1, r, rs);
            merge(pairs, l, m, r, rs);
        }
    }

    public void merge(int[][] pairs, int l, int m, int r, List<Integer> rs) {
        int len1 = m - l + 1;
        int len2 = r - m;

        int[][] arr1 = new int[len1][2];
        int[][] arr2 = new int[len2][2];

        for (int i = 0; i < len1; i++) arr1[i] = pairs[l + i];
        for (int i = 0; i < len2; i++) arr2[i] = pairs[m + 1 + i];

        int i = 0, j = 0, k = l;
        int countRightSmaller = 0;

        while (i < len1 && j < len2) {
            if (arr1[i][0] > arr2[j][0]) {
                pairs[k++] = arr2[j++];
                countRightSmaller++;
            } else {
                rs.set(arr1[i][1], rs.get(arr1[i][1]) + countRightSmaller);
                pairs[k++] = arr1[i++];
            }
        }

        while (i < len1) {
            rs.set(arr1[i][1], rs.get(arr1[i][1]) + countRightSmaller);
            pairs[k++] = arr1[i++];
        }

        while (j < len2) {
            pairs[k++] = arr2[j++];
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> rs = new ArrayList<>();
        for (int i = 0; i < n; ++i) rs.add(0);

        int[][] pairs = new int[n][2]; 
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        sort(pairs, 0, n - 1, rs);
        return rs;
    }
}
