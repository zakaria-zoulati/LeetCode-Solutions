class Solution {
    public int thirdMax(int[] arr) {
        int n = arr.length ; 
        int large = Arrays.stream(arr).max().getAsInt();
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if(arr[i] > b && arr[i] != large) {
                b = arr[i];
            }
        }
        if( b == Integer.MIN_VALUE ){
            return large ; 
        }

        boolean flag = false ; 

        for (int i = 0; i < n; i++) {
            if(arr[i] >= c && arr[i] != large && arr[i] != b   ) {
                c = arr[i];
                flag = true ; 
            }
        }

        if( flag  ){
            return c; 
        }

        return large ; 
    
    }
}