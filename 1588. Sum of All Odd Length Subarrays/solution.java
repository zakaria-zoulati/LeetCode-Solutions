class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length ; 
        int rs = 0 ;
        for(int i=0 ; i<n ; ++i){
            int start = i+1 ; 
            int end = n-i ; 
            int total = start*end ; 
            int odds = total/2 ; 
            if( total % 2 != 0  ){
                odds++ ; 
            }
            rs += arr[i]*odds ; 
        }
        return rs ;
    }
}