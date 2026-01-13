class Solution {
    public String removeOccurrences(String s, String part) {
        int m = part.length() ; 
        while( s.indexOf( part ) != -1 ){
            int in = s.indexOf( part ) ; 
            s = s.substring(0,in)+ s.substring(in+m, s.length()) ; 
        }
        return s; 
    }
}