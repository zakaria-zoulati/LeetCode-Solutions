class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int curr = 0 ; 
        int x = 0;  
        int y = 0;
        HashMap<Integer,ArrayList<Integer>> mapX = new HashMap<>() ; 
        HashMap<Integer,ArrayList<Integer>> mapY = new HashMap<>() ; 
        for( int[] obs : obstacles ){
            if( mapX.get( obs[0] ) == null ){
                mapX.put( obs[0] , new ArrayList<>() ) ; 
            }
            mapX.get( obs[0] ).add( obs[1] ) ; 
            if( mapY.get( obs[1]) == null ){
                mapY.put( obs[1] , new ArrayList<>() ) ; 
            }
            mapY.get( obs[1] ).add( obs[0] ) ; 
        }
        int rs = 0 ; 
        for(int i : commands){
            if( i == -1 ){
                curr = (curr + 1)%4 ; 
            }
            else if( i==-2 ){
                curr = ( curr +3)%4 ; 
            }
            else {
                if( curr == 0 ){
                    if( mapX.get( x ) == null ){
                        y += i ; 
                    }else {
                        while( i>0 && !mapX.get( x ).contains(y+1) ){
                            y++; 
                            i--;
                        }
                    }
                }
                else if( curr == 1 ){
                    if( mapY.get( y ) == null ){
                        x +=i ;
                    }else {
                        while( i>0 && !mapY.get(y).contains(x+1) ){
                            x++ ; 
                            i-- ; 
                        }
                    }
                }
                else if( curr == 2 ){
                    if( mapX.get( x ) == null ){
                        y -= i ; 
                    }else {
                        while( i>0 && !mapX.get(x).contains(y-1) ){
                            y-- ; 
                            i-- ; 
                        }
                    }
                }else {
                    if( mapY.get( y ) == null ){
                        x -= i ; 
                    }else {
                        while( i>0 && !mapY.get(y).contains(x-1) ){
                            x-- ; 
                            i-- ; 
                        }
                    }
                }

                rs = Math.max( rs ,(x*x) + (y*y)  ) ;
                
            }
        }
        return rs  ; 

    }
}