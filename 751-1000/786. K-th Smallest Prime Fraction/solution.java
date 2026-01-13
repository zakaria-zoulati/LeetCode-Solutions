class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double low = 0;
        double high = 1.0;
        while(low<high){
            double mid = (low+high)/2;
            int res[] = countLessThanMid(arr,k,n,mid);
            if(res[0]==k) return new int[]{arr[res[1]],arr[res[2]]};
            else if(res[0]>k) high = mid;
            else low = mid;
        }
        return new int[]{};
    }
    
    private int[] countLessThanMid(int arr[],int k,int n,double mid){
        double maxLessThanMid = 0.0;
        int x = 0; 
        int y = 0;
        int total = 0;
        int j = 1;
        for(int i=0;i<n-1;i++){    
            while(j<n && arr[i]>arr[j]*mid){
                j++;
            }
            if(j==n) break;
            total+=(n-j); 
            double fraction = (double)arr[i]/arr[j];
            if(fraction>maxLessThanMid){
                maxLessThanMid = fraction;
                x = i;
                y =j;
            }
        }
        return new int[]{total,x,y};
    }
}