class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length() ; 
        int[] arr = new int[n] ; 
        int helper = 0 ; 
        for(int i=n-1 ;i>=0 ; --i ){
            if(  s.charAt(i)  == c ){
                helper = i ; 
            }
            arr[i] = helper - i  ; 
        }
        int[] rs = new int[n] ; 
        int inter = 0 ;
        boolean flag = false ; 
        for(int i=0 ; i<n ; ++i){
            if( s.charAt(i) == c ){
                inter = i ; 
                flag = true ; 
            }
            if( flag ){
                if( arr[i] >0 ){
                    rs[i] = Math.min( arr[i] , i-inter ) ; 
                }else {
                    rs[i] = i - inter ;
                }
            }else{
                rs[i] = arr[i] ; 
            }
           
        }

        return rs ; 
    }
}