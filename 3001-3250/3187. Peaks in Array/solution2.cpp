class Solution {
    public:
        int get(vector<int> &mo, vector<int> &nums, int len, int n, int l, int r) {
            int c1 = l / len;
            int c2 = r / len;
            int rs = 0;
            if (c1 == c2) {
                for (int i = l+1; i <= r-1; ++i) {
                    if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) rs++ ; 
                }
                return rs;
            } else {
                for (int i = l+1; i < (c1 + 1) * len ; ++i) {
                    if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) rs++ ;  
                }
                for (int c = c1 + 1; c < c2; ++c) rs += mo[c] ; 
                for (int i = c2 * len; i <= r-1; ++i) {
                    if (nums[i] > nums[i-1] && nums[i] > nums[i + 1]) rs++ ;  
                }
                return rs;
            }
        }
        
        void change(vector<int> &mo, vector<int> &nums, int len, int n, int i, int val) {
            int prev = nums[i];
            if (i==0 && nums[1] > nums[2] ) {
                int d = ( nums[1] > prev ? -1 : 0 ) + ( nums[1] > val ? 1 : 0 ) ; 
                mo[1/len] += d ; 
            }
            else if ( i==n-1 && nums[i-2] < nums[i-2]) {
                int d = ( nums[i-1] > prev ? -1 : 0 ) + ( nums[i-1] > val ? 1 : 0 ) ; 
                mo[(i-1)/len] += d ; 
            }
            else if( i>0 && i<n-1 ) {
                if( i-1>0 && nums[i-1] > nums[i-2] ){
                    int d = ( nums[i-1] > prev ? -1 : 0 ) + ( nums[i-1] > val ? 1 : 0 ) ; 
                    mo[(i-1)/len] += d;  
                }
                if( i+1<n-1 && nums[i+1] > nums[i+2] ){
                    int d = ( nums[i+1] > prev ? -1 : 0 ) + ( nums[i+1] > val ? 1 : 0 ) ; 
                    mo[(i+1)/len] += d ; 
                }
                mo[i/len] += ( prev > nums[i-1] && prev > nums[i+1] ? -1 : 0 ) + 
                ( val > nums[i-1] && val > nums[i+1] ? 1 : 0 ) ; 
            }
            
            nums[i] = val;
        }
        
        vector<int> countOfPeaks(vector<int>& nums, vector<vector<int>>& queries) {
            int n = nums.size();
            int len = sqrt(n) + 1;
            vector<int> mo(len, 0);
            for (int i = 1; i < n - 1; ++i) {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    mo[i / len]++;
                }
            }
            vector<int> rs;
            for (auto& query : queries) {
                int t = query[0], u = query[1], v = query[2];
                if (t == 1) {
                    int curr = get(mo, nums, len, n, u, v);
                    rs.push_back(curr);
                } else {
                    change(mo, nums, len, n, u, v);
                }
            }
            return rs;
        }
    };