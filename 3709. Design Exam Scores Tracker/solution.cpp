using ll = long long ; 

class ExamTracker {
public:
    vector<pair<int,ll>> pref ; 
    ExamTracker() {
        // 
    }
    void record(int time, int score) {
        if( pref.empty() ){
            pref.push_back( { time , score } ) ; 
        }else {
            pref.push_back( { time , score + pref[pref.size()-1].second  } ) ; 
        }
    }
    
    long long totalScore(int startTime, int endTime) {
        if( pref.empty() ) return 0LL ; 
        if( pref[0].first > endTime || pref[pref.size()-1].first < startTime  ){
            return 0LL ; 
        }
        startTime = max( startTime , pref[0].first ) ; 
        endTime = min( endTime , pref[pref.size()-1].first ) ; 
        ll l1 = 0 ; 
        int r1 = pref.size() - 1; 
        while( l1<r1  ){
            int mid = l1 + ( r1 - l1 )/2 ; 
            if( startTime <= pref[mid].first ){
                r1 = mid  ;  
            }else {
                l1 = mid + 1 ;  ; 
            }
        }
        int l2 = 0 ; 
        int r2 = pref.size() - 1 ; 
        while( l2 < r2 ){
            int mid = l2 + ( r2 - l2 + 1 )/2 ; 
            if( endTime < pref[mid].first ){
                r2 = mid -1  ; 
            }else {
                l2 = mid ; 
            }
        }
        if( l1 == 0 ) return pref[l2].second ; 
        else return pref[l2].second - pref[l1-1].second ; 
    }
};

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker* obj = new ExamTracker();
 * obj->record(time,score);
 * long long param_2 = obj->totalScore(startTime,endTime);
 */