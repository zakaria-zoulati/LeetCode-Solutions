class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] a = new int[(nums.length)];
        int k = 0;
        for(int i: nums){
            if(i<pivot){
                a[k++]=i;
            }
        }
        for(int i:nums){
            if(i==pivot){
                a[k++]=i;
            }
        }
        for(int i:nums){
            if(i>pivot){
                a[k++]=i;
            }
        }
        return a;
    }
}