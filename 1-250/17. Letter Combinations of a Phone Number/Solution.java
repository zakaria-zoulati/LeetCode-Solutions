import java.util.* ; 
class Solution {
    public void backtrack( String digits , Map<Integer,String> map ,  char[] chars , int in , List<String> rs  ){
        if( in == digits.length()  ){
            rs.add( new String( chars ) ) ; 
            return ; 
        }
        int num = digits.charAt(in) - '0' ; 
        for( char c : map.get(num).toCharArray() ){
            chars[in] = c ; 
            backtrack( digits , map , chars , in+1 , rs ) ; 
        }
    }
    public List<String> letterCombinations(String digits) {
        int n = digits.length() ; 
        if( n == 0 ) return new ArrayList<>() ; 
        Map< Integer , String > map = new HashMap<>() ;  
        map.put( 2 , "abc" ) ; 
        map.put( 3 , "def" ) ; 
        map.put( 4 , "ghi" ) ;
        map.put( 5 , "jkl" ) ;  
        map.put( 6 , "mno" ) ;  
        map.put( 7 , "pqrs" ) ;
        map.put( 8 , "tuv" ) ; 
        map.put( 9 , "wxyz" ) ; 
        List<String> rs = new ArrayList<>() ; 
        char[] chars = new char[n] ; 
        backtrack( digits, map,  chars , 0 , rs ) ; 
        return rs ;   
    }
}