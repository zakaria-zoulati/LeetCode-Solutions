/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int num=rand7()+(rand7()-1)*7;
        if(num<=40)return num%10+1;
        else return rand10();
    }
}