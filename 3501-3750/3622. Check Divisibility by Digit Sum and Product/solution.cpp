#include <bits/stdtr1c++.h>

using namespace std ; 

class Solution {
public:
    bool checkDivisibility(int n) {
        int sum = 0 ; 
        int product = 1 ;
        int copy = n ; 
        while( copy > 0 ){
            sum += copy % 10 ; 
            product *= ( copy % 10 ) ; 
            copy /= 10 ; 
        }
        return n % ( sum + product ) == 0 ; 
    }
};