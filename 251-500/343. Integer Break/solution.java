class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() >= t.length()) {
            return s.equals(t);
        }
        
        byte a = 0;
        int i=0 ; 
        while(i<t.length() && a!=s.length()){
            if(t.charAt(i)==s.charAt(a)){
                a++ ;
            }
            i++ ;

        }
       return a == s.length(); 
    }
}
