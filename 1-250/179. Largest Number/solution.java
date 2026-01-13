class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> (b+a).compareTo(a+b)
        );

        for (int i = 0; i < n; ++i) {
            pq.add(String.valueOf(nums[i]));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
