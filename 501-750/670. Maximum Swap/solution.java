class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num) ; 
        int len = s.length() ; 
        char[] chars = s.toCharArray() ; 
        for(int i=0 ; i<len ; ++i){
            boolean flag = false ; 
            int index = -1; 
            char curr = chars[i] ; 
            for( int j=i+1 ; j<len ; ++j ){
                if( chars[i] != chars[j] && curr <= chars[j] ){
                    flag = true ; 
                    index = j ; 
                    curr = chars[j] ; 
                }
            }
            if(flag){
                swap( chars , i , index ) ; 
                break ; 
            }
        }
        return Integer.parseInt( new String(chars) ) ; 
    }
    public void swap( char[] arr , int i , int j ){
        char curr = arr[i] ; 
        arr[i] = arr[j] ; 
        arr[j] = curr; 
    }
}