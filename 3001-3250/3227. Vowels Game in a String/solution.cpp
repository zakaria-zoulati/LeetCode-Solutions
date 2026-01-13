#include <string>
using namespace std ; 
class Solution {
public:
    bool doesAliceWin(string s) {
        for( char c : s ){
            if( c=='a'|| c=='e'||c=='u'||c=='i'||c=='o' ){
                return true ; 
            }
        }
        return false ; 
    }
};