class Solution {
    public int countTriplets(int[] arr) {
        int all = 0 ;
        int n = arr.length ; 
        int rs = 0 ; 
        for(int i=0 ; i<n ;i++){
            long first = 0 ; 
            for(int j=i+1 ; j<n ; j++){
                first = first^arr[j-1] ; 
                long second = 0 ; 
                for(int k = j ; k<n ; k++ ){
                    second = second ^ arr[k] ; 
                    if( first == second ){
                        rs++; 
                    }
                }
            }
        }
        return rs ; 
    }
}