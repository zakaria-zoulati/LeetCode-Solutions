class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length ; 
        int max = 0 ; 
        for(int i=0 ; i<n ;++i){
            if(  arr[i] == arr[ i+n/4  ] ){
                return arr[i] ; 
            }
        }
        return -1  ; 
    }
}