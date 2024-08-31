class Solution {
    public int findSpecialInteger(int[] arr) {
        int rs = 0 ; 
        int n = arr.length ; 
        int max = 0 ; 
        for(int i=0 ; i<n ;++i){
            int count = 1  ;
            while( i+1 <n && arr[i+1] == arr[i] ){
                count++ ; 
                i++  ;
            }
            if( count > max  ){
                rs = arr[i] ; 
                max = count ; 
            }
        }
        return rs ; 
    }
}