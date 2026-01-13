class Solution {
    public long pickGifts(int[] gifts, int k) {
        int n = gifts.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            pq.add(gift);
        }
        for (int i=0; i<k; ++i) {
            int curr = pq.poll();
            pq.add((int) Math.sqrt(curr));
        }
        Object[] remaining = pq.toArray();
        long rs = 0;
        for (Object pile : remaining) {
            rs += (int) pile;
        }
        return rs;
    }
}