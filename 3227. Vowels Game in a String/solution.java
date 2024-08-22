class Solution {
    public boolean doesAliceWin(String s) {
        int vowels = 0 ; 
        for( char c : s.toCharArray() ){
            if( c=='a' || c=='e' || c=='i' || c=='a' || c=='o' || c=='u' ) vowels++ ; 
        }
        if(vowels!=0 ){
            return true ;
        }
        return false ; 
    }
}