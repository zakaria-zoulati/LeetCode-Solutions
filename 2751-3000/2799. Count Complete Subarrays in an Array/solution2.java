class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashSet<Integer> uniqueElements = new HashSet<>();
        for (int num : nums) {
            uniqueElements.add(num);
        }
        int totalUnique = uniqueElements.size();
        if (totalUnique == 1) {
            return n * (n + 1) / 2;
        }
        
        int result = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;
        for (int right = 0; right < n; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
            while (freqMap.size() == totalUnique) {
                result += n - right;
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if (freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }
                left++;
            }
        }

        return result;
    }
}
