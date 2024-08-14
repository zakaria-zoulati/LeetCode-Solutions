class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length() ; 
        ArrayList<Integer> arr = new ArrayList<>() ; 
        for(int i=0 ;i<n ;++i ){
            if(  s.charAt(i)  == c ){
                arr.add(i) ; 
            }
        }
        int len = arr.size() ;
        int[] rs = new int[n] ; 
        int current = 0 ; 
        int ok = arr.get(0) ; 
        for(int i=0 ; i<=ok  ; ++i ){
            rs[current++] = ok - i  ; 
        }
        for(int i=0 ; i<len-1 ; ++i){
            for(int j = arr.get(i)+1 ; j<arr.get(i+1) ; ++j ){
                 rs[current] = Math.min( Math.abs( current - arr.get(i) ) , Math.abs( current - arr.get(i+1) )) ; 
                 current++ ; 
            }
            rs[current++] = 0 ;
        }
        int inter = arr.get( len -1 ) ; 
        for(int i= arr.get( len -1 ) +1 ; i<n ; ++i ){
            rs[current++] = i - inter ; 
        }
        return rs ; 
    }
}