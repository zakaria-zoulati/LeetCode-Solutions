class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> sumMap =new HashMap();
        int[] res=new int[2];
        for(int i=0;i<nums.length;i++){
            if(sumMap.containsKey(target - nums[i])){
                res[0]=sumMap.get(target-nums[i]);
                res[1]=i;
                return res;
            }
            sumMap.put(nums[i], i);
        }

        return res;
    }
}