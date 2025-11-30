class Solution {
public:
    int getStart(vector<int> &in, vector<int> &out, int count) {
        for(int i = 0; i < count; i++) {
            if(out[i] == in[i] + 1) return i;
        }
        return 0 ; 
    } 

    vector<int> euler_path(int start , vector<vector<int>> &edges){
        stack<int> st;
        vector<int> path;
        st.push(start);

        while(!st.empty()){
            int u = st.top();
            if(!edges[u].empty()){
                int v = edges[u].back();
                edges[u].pop_back();
                st.push(v);        
            } else {
                path.push_back(u);
                st.pop();
            }
        }

        reverse(path.begin(), path.end());
        return path;
    }

    vector<vector<int>> validArrangement(vector<vector<int>>& pairs) {
        int n = pairs.size();
        if( n == 1 ) {
            return pairs ; 
        }
        vector<int> eles;
        unordered_map<int,int> prev_new;
        unordered_map<int,int> new_prev;
        int count = 0;

        for(auto &p : pairs){
            eles.push_back(p[0]);
            eles.push_back(p[1]);
        }

        sort(eles.begin(), eles.end());

        for(int i = 0; i < eles.size(); i++){
            prev_new[eles[i]] = count;
            new_prev[count] = eles[i];   

            while(i + 1 < eles.size() && eles[i+1] == eles[i]) i++;
            count++;
        }

        vector<vector<int>> edges(count);
        vector<int> indeg(count, 0), outdeg(count, 0);

        for(auto &p : pairs){
            int u = prev_new[p[0]];
            int v = prev_new[p[1]];
            edges[u].push_back(v);   
            outdeg[u]++;
            indeg[v]++;
        }

        int start = getStart(indeg, outdeg, count); 
        vector<int> path = euler_path(start, edges);

        vector<vector<int>> ans;
        for(int i = 1; i < path.size(); i++){
            ans.push_back({ new_prev[path[i-1]] , new_prev[path[i]] });
        }

        return ans;
    }
};
