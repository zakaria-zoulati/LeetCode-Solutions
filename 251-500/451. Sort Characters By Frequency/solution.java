class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        if (n == 0) return "";

        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> freq[b] - freq[a]
        );

        for (int i = 0; i < 128; i++) {
            if (freq[i] > 0) {
                pq.add((char) i);
            }
        }

        StringBuilder rs = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            int count = freq[c];
            rs.append(String.valueOf(c).repeat(count));
        }

        return rs.toString();
    }
}
