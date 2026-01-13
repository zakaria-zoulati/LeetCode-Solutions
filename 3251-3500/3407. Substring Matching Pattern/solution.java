class Solution {
    public boolean hasMatch(String s, String p) {
        int n = s.length() ; 
        int in = p.indexOf('*');
        String fi = p.substring(0, in);
        String se = p.substring(in + 1);
        int inn = s.indexOf( fi ) ; 
        if( inn != -1 && s.substring( inn + fi.length() ).contains(se) ){
            return true; 
        }
        return false ; 
    }
}
