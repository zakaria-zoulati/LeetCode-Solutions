class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int n=digits.size(),c=0;
        if(digits[n-1]<9){
            digits[n-1]++; return digits;
        }
        c=1; digits.push_back(0);
      for(int i=n-2; i>=0; i--){
            if(digits[i]==9 && c==1){digits[i+1]=0;}
            else if(c==1){digits[i+1]=(digits[i]+1); c=0;}
            else digits[i+1]=digits[i];
      }
      if(c==1) digits[0]=1;
      else digits.erase(digits.begin());
      return digits;
      
    }
};
