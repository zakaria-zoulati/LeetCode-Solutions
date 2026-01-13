class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length() ; 
        int[] rs = new int[n] ; 
        int[] right = new int[n] ; 
        int count = 0 ; 
        for(int i=0 ; i<n ; ++i ){
            if( count >0 ){
                rs[i] = count + rs[i-1] ;
            }
            if( boxes.charAt(i) == '1' ){
                count++ ; 
            }
        }
        count = 0 ;
        for(int i=n-1 ; i>=0; i--){
            if( count > 0 ){
                right[i] = count + right[i+1] ; 
             }
             if( boxes.charAt(i) == '1' ){
                count++ ;
             }
        }

        for(int i=0 ; i<n ; ++i){
            rs[i] +=  right[i] ; 
        }

        return rs ; 
    }
}