class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
       StringBuilder rs1 = new StringBuilder() ; 
       StringBuilder rs2 = new StringBuilder() ; 
       for( String s : word1 ){
        rs1.append( s ) ; 
       }
       for( String s : word2 ){
        rs2.append( s ) ; 
       }
       return rs1.toString().equals( rs2.toString() ) ; 
    }
}