class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length ; 
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int count[]=new int[max+2];
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }
        int res=0;
        for(int i=0;i<=max;i++){
            if(count[i] > 1){
                res+=count[i]-1;
                count[i+1]+=count[i]-1;
            }
        }
        if(count[max+1] > 1){
            if(count[max+1]%2==0){
                res+=(count[max+1]/2)*(count[max+1]-1);
            }else{
                res+=((count[max+1]-1)/2)*(count[max+1]);
            }
        }
        return res;
    }
}