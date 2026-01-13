class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        List<Integer>list=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int [][]dt=new int [m][n];
                                
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0  && j==0)
                {
                    dt[i][j]=matrix[i][j];

                }
                else if(i==0)
                {
                    dt[i][j]=matrix[i][j]^dt[i][j-1];
                }
                else if(j==0)
                {
                    dt[i][j]=matrix[i][j]^dt[i-1][j];
                }
                else{
                    dt[i][j]=dt[i-1][j]^dt[i][j-1]^dt[i-1][j-1]^matrix[i][j];
                }
                
                list.add(dt[i][j]);
            }
        }
        return QuickSelect(list,k);     
    }
    public int QuickSelect(List<Integer>nums,int k){
        int pivotIndex=new Random().nextInt(nums.size());
        int pivot=nums.get(pivotIndex);
        List<Integer>left=new ArrayList<>();
        List<Integer>mid=new ArrayList<>();
        List<Integer>right=new ArrayList<>();
        for(int num:nums){
            if(num>pivot){
                left.add(num);

            }
            else if(num<pivot){
                right.add(num);
            }
            else{
                mid.add(num);
            }
        }
        if(k<=left.size()){
            return QuickSelect(left,k);
        }
        if(left.size()+mid.size()<k){
            return QuickSelect(right,k-left.size()-mid.size());
        }
        return pivot;

    }
}