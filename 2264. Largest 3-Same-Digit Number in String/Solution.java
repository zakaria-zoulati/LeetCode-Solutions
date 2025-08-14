class Solution {
    public String largestGoodInteger(String num) {
     String[] sols={"999","888","777","666","555","444","333","222","111","000"};
     for(String i:sols){
        if(num.contains(i)){
            return i;
        }
     }
     return "";

    }
}