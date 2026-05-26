#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    int numberOfSpecialChars(string word)
    {
        int n = word.size();
        vector<bool> upper(26, false);
        vector<bool> lower(26, false);
        for (int i = 0; i < n; ++i)
        {
            if (word[i] > 'Z')
            {
                lower[word[i] - 'a'] = true;
            }
            else
            {
                upper[word[i] - 'A'] = true;
            }
        }

        int ans = 0;
        for (int i = 0; i < 26; ++i)
        {
            if (upper[i] && lower[i])
            {
                ans++;
            }
        }
        return ans;
    }
};