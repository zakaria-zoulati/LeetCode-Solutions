#include<bits/stdc++.h>
using namespace std;
class RideSharingSystem {
unordered_map<int, int> rd, dr;
vector<int> driver, rider;
int idx1, idx2;
public:
    RideSharingSystem() {
        idx1 = idx2 = 0; 
    }
    
    void addRider(int riderId) {
        rider.push_back(riderId);
        int sz = rider.size();
        rd[riderId] = sz - 1;
    }
    
    void addDriver(int driverId) {
        driver.push_back(driverId);
        int sz = driver.size();
        dr[driverId] = sz - 1;
    }
    
    vector<int> matchDriverWithRider() {
        if (rd.empty() || dr.empty()) return {-1, -1};
        vector<int> ans = {driver[idx2], rider[idx1]};
        rd.erase(rider[idx1]);
        dr.erase(driver[idx2]);
        idx1++, idx2++;
        while (idx1 < rider.size() && rider[idx1] == -1) idx1++;
        while (idx2 < driver.size() && driver[idx2] == -1) idx2++;
        return ans;
    }
    
    void cancelRider(int riderId) {
        auto it = rd.find(riderId);
        if (it == rd.end()) return;
        int idx = rd[riderId];
        rider[idx] = -1;
        rd.erase(riderId);
        while (idx1 < rider.size() && rider[idx1] == -1) idx1++;
    }
};

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem* obj = new RideSharingSystem();
 * obj->addRider(riderId);
 * obj->addDriver(driverId);
 * vector<int> param_3 = obj->matchDriverWithRider();
 * obj->cancelRider(riderId);
 */