class Solution {
    public int numberOfSpecialChars(String word) {
        int rs = 0 ; 
        String min = "abcdefghijklmnopqrstuvwxyz" ; 
        String maj = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" ; 
        for(int i=0 ; i<26 ; ++i){
            int a = word.lastIndexOf( min.charAt(i) ) ; 
            int b = word.indexOf( maj.charAt(i) ) ; 
            if( a != -1 &&  b != -1 ){
                if( a < b   ) rs++ ;
            }
        }
        return rs ; 
    }
}