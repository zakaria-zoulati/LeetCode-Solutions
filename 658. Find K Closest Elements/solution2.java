class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = 0, j = arr.length - k;
        while (i < j){
            int mid = (i & j) + ((i ^ j) >> 1);
            if(x - arr[mid] > arr[mid + k] - x)
                i = mid + 1;
            else
                j = mid;
        }
        List<Integer> res = new ArrayList<>();
        for (int b = i; b < i + k; ++b) res.add(arr[b]);
        return res;
    
    }
}