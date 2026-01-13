class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length == 0) return res;
        backtrack(nums, 0);
        return res;
    }

    void backtrack(int[] nums, int start) {
        if(track.size() >= 2) res.add(new LinkedList<>(track));
        HashSet<Integer> used = new HashSet<>();
        for(int i = start; i < nums.length; i++) {
            if(!track.isEmpty() && track.getLast() > nums[i] || used.contains(nums[i])) continue;
            used.add(nums[i]);
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}