class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int rs = 0 ; 
        for(char ch: stones.toCharArray() ){
            if( jewels.indexOf(ch) != -1  ) rs++ ;
        }
        return rs ; 
    }
}