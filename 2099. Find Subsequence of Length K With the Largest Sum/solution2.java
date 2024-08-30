class Solution{
    public int[] maxSubsequence(int[] nums,int k){
        PriorityQueue<Integer> min=new PriorityQueue<>((a,b)->nums[a]-nums[b]);
        int[] temp=new int[nums.length];
        for(int i=0;i<k;i++){
            min.add(i);
            temp[i]=1;
        }
        for(int i=k;i<nums.length;i++){
            int j=min.peek();
            if(nums[j]<nums[i]){
                min.poll();
                min.add(i);
                temp[j]=0;
                temp[i]=1;
            }
        }
        int[] res=new int[k];
        for(int i=0,j=0;i<temp.length;i++){
            if(temp[i]==1){
                res[j++]=nums[i];
            }
        }
         return res;
    }
}






