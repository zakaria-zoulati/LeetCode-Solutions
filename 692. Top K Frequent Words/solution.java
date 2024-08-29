class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> 
            !freqMap.get(a).equals(freqMap.get(b)) ? freqMap.get(b) - freqMap.get(a): a.compareTo(b) 
        );

        for (String word : freqMap.keySet()) {
            pq.offer(word);
        }

        List<String> result = new ArrayList<>(k);
        for(int i=0 ; i<k ; ++i){
            result.add(pq.poll());
        }

        return result;
    }
}
