
class Solution {
public:
    int numSplits(string str) {
        int n = str.length();
        
        vector<int> pref(n), suff(n);
        
        map<char, int> freq;
        
        for(int i = 0; i < n; i++)
        {
            freq[str[i]]++;
            pref[i] = freq.size();
        }
        
        freq.clear();
        
        for(int i = n -1; i >= 0; i--)
        {
            freq[str[i]]++;
            suff[i] = freq.size();
            
        }
       
        int ans = 0;
        for(int i = 1; i < (n); i++)
        {
            if(pref[i - 1] == suff[i])
                ans++;
        }
        
        return ans;
        
    }
};

