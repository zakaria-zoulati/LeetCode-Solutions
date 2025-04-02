class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int max = Integer.MIN_VALUE;
        int[] next = new int[nums.size()];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new int[]{nums.get(i).get(0), i});
            max = Math.max(max, nums.get(i).get(0));
        }
        

        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;
        
        while (pq.size() == nums.size()) {
            int[] min = pq.poll();
            int value = min[0];
            int listIndex = min[1];
            
            if (max - value < range) {
                range = max - value;
                start = value;
                end = max;
            }
            
            next[listIndex]++;
            if (next[listIndex] < nums.get(listIndex).size()) {
                int nextValue = nums.get(listIndex).get(next[listIndex]);
                pq.offer(new int[]{nextValue, listIndex});
                max = Math.max(max, nextValue);
            } else {
                break;
            }
        }
        
        return new int[]{start, end};
    }
}