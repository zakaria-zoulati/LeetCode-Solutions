class Solution {
    public int maxChunksToSorted(int[] arr) {
        int len = arr.length;
        int maxLeft[] = new int[len];
        int minRight[] = new int[len];
        maxLeft[0] = arr[0];
        for(int i = 1; i < len; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], arr[i]);
        }

        minRight[len-1] = Integer.MAX_VALUE;
        for(int i = arr.length-2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i+1], arr[i+1]);
        }

        int res = 0;
        for(int i = 0 ; i < len; i++) {
            if(minRight[i] >= maxLeft[i])
                res++;
        }
        return res;
    }
}