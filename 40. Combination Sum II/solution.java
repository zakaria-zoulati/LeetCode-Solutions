class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);  
        backtrack(list, temp, nums, target, 0 ,nums.length);
        return list;
    }
    public void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int target, int idx ,int n ) {
        if (target == 0) {
            list.add(new ArrayList<>(temp)); 
            return;
        }
        for (int i = idx; i < n ; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue; 
            }
            if (nums[i] <= target) {
                temp.add(nums[i]);  
                backtrack(list, temp, nums, target - nums[i], i + 1 , n );  
                temp.remove(temp.size() - 1);  
            }
        }
    }
}
