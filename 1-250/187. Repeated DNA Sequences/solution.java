class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>() ; 
        HashMap<String , Integer> map = new HashMap<>() ; 
        int n = s.length() ; 
        for(int i=0 ; i+10<=n ; ++i){
            map.put( s.substring( i , i+10 ) , map.getOrDefault( s.substring(i,i+10) , 0 ) +1 ) ; 
        }
        for( String key : map.keySet() ){
            if( map.get(key) >=2 ){
                list.add(key) ; 
            }
        }
        return list ; 
    }
}