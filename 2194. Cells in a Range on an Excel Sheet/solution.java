class Solution {
    public List<String> cellsInRange(String s) {
        int a = s.charAt(1) - '0' ; 
        int b = s.charAt(4) - '0' ; 
        int first = (int) s.charAt(0) ; 
        int second = (int)  s.charAt(3) ;
        List<String> rs = new ArrayList<>() ; 
        for(int j=first ; j<=second ; ++j){
            for(int i=a ; i<=b ; ++i){
                StringBuilder inter = new StringBuilder() ; 
                inter.append( (char) j  ) ; 
                inter.append( i ) ; 
                rs.add( inter.toString() ) ; 
            }
        }

        return rs ;
    }
}