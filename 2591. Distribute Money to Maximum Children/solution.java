class Solution {
    public int distMoney(int money, int children) {
        int rs = 0 ; 
        if( money < children ){
            return -1 ; 
        }
        if( children ==1 && money == 4 ){
            return -1 ; 
        }
        while( money - 8 >= children -1   ){
            if( children == 1 && money != 8  ){
                break ; 
            }
            rs++ ; 
            money -= 8 ; 
            children-- ; 
        } 
        if( rs == 0 ){
            return 0 ; 
        } 
        if( money == 4 && children ==1  ){
            rs-- ; 
        }
        return rs ; 

    }
}