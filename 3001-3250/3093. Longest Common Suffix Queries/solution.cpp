#include <bits/stdc++.h>

using namespace std ;

class Solution {
public:
    struct Node {
        int childs[26] ; 
        int len ;
        int idx ; 
    };

    vector<Node> trie ; 

    int newNode(){
        trie.push_back({}) ; 
        Node& nd = trie.back() ; 
        fill( nd.childs , nd.childs + 26 , -1 ) ; 
        nd.len = INT_MAX ; 
        nd.idx = -1 ; 
        return (int) trie.size() - 1 ; 
    }


    void insert( string &s , int j ){
        int curr = 0 ; 
        int n = s.size() ; 
        if( n < trie[curr].len )  {
            trie[curr].len = n ; 
            trie[curr].idx = j ; 
        }
        for( int i=n-1 ; i>=0 ; --i ){
            int c = s[i] - 'a' ; 
            if( trie[curr].childs[c] == -1 ){
                int nxt = newNode() ; 
                trie[curr].childs[c] = nxt ; 
            }
            curr = trie[curr].childs[c] ; 
            if( n < trie[curr].len ){
                trie[curr].len = n ; 
                trie[curr].idx = j ; 
            }
        }
    }

    int query( const string &s ){
        int curr = 0 ; 
        int n = s.size() ; 
        for( int i=n-1 ; i>=0 ; --i ){
            int c = s[i] - 'a' ; 
            if( trie[curr].childs[c] == -1 ) break ; 
            curr = trie[curr].childs[c] ; 
        }
        return trie[curr].idx ; 
    }

    vector<int> stringIndices(vector<string>& wordsContainer, vector<string>& wordsQuery) {
        int n = wordsContainer.size() ;
        int totalChars = 0 ; 
        for( int i=0; i<n ; ++i ){
            totalChars += wordsContainer[i].size() ; 
        }

        trie.reserve( totalChars + 1 ) ; 
        newNode() ; 

        for( int i=0 ; i<n ; ++i ){
            insert( wordsContainer[i] , i ) ;  
        }
 
        int q = wordsQuery.size() ; 
        vector<int> ans(q) ; 
        for( int i=0 ; i<q ; ++i ){
           ans[i] = query( wordsQuery[i] ) ; 
        }
        return ans ;
    }
};
