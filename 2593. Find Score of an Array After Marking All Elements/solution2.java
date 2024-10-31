class Solution {
    public long findScore(int[] nums) {
        long rs = 0 ; 
        int n=nums.length;
        int a[][]=new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=i;
            a[i][1]=nums[i];
        }
        Arrays.sort(a,(x,y)->x[1]-y[1]);
        for(int i=0;i<n;i++){
            int index=a[i][0];
            if(nums[index]==-1) continue;
            rs+=nums[index];
            nums[index]=-1;
            if(index>0) nums[index-1]=-1;
            if(index<n-1) nums[index+1]=-1;
        }
        return rs;
    }
}