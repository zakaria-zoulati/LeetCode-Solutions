class Solution {
    public boolean doesAliceWin(String s) {
        for( char c : s.toCharArray() ){
            switch(c){
                case 'a' , 'e' , 'u' , 'i' , 'o' : 
                    return true  ;
            }
        }
        return false ; 
    }
}