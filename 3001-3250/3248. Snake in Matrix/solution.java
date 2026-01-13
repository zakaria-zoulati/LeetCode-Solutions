class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0 ; 
        int j = 0 ; 
        int len = commands.size(); 
        for(int k=0 ; k<len ; ++k){
            if( commands.get(k).equals("RIGHT") ){
                ++j ; 
            }
            else if(  commands.get(k).equals("LEFT") ){
                --j ; 
            }else if( commands.get(k).equals("UP") ){
                --i ; 
            }else {
                ++i ; 
            }
        }
        int rs = n*i+j ; 
        return rs ;
    }
}