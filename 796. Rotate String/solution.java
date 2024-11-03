class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!= goal.length()){
            return false ;
        }
        int n = goal.length() ;
        boolean flag = false ;
        for(int  i=0 ; i< n ;i++){
            if(s.charAt(i)==goal.charAt(0)){
                flag = flag || ((s.substring(i,n)+s.substring(0,i)).equals(goal)) ;
            }
        }
        return flag ;
    }
}