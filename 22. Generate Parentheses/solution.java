class Solution {

    public List<String> fill(  String p ,  List<String> list , int open , int close ){
        if( open == 0 && close == 0  ){
            list.add(p) ; 
            return list ; 
        }
        if( open > 0  ){
            fill( p + "(" ,  list , open -1 , close  )  ;
        }
        if( close > open ){
           fill( p + ")"  , list , open , close -1 ) ; 
        }
        return list; 
    }

    public List<String> generateParenthesis(int n) {
        List<String> all = new ArrayList<>() ; 
        fill( "" ,  all , n , n  ) ; 
        return all ;
    }
}