#include<bits/stdc++.h>
using namespace std;
class AuctionSystem {
map<int, map<pair<int, int>, int>> items;
map<pair<int, int>, int> bid;
public:
    AuctionSystem() {
        
    }
    
    void addBid(int userId, int itemId, int bidAmount) {
        if (bid[{userId, itemId}]) {
            updateBid(userId, itemId, bidAmount);
            return;
        }
        items[itemId].insert({{-bidAmount, -userId}, {1}});
        bid[{userId, itemId}] = bidAmount;
    }
    void updateBid(int userId, int itemId, int newAmount) {
        int oldAmount = bid[{userId, itemId}];
        items[itemId].erase({-oldAmount, -userId});
        items[itemId].insert({{-newAmount, -userId}, {1}});
        bid[{userId, itemId}] = newAmount;
    }
    
    void removeBid(int userId, int itemId) {
        int oldAmount = bid[{userId, itemId}];
        bid.erase({userId, itemId});
        items[itemId].erase({-oldAmount, -userId});
    }
    
    int getHighestBidder(int itemId) {
        map<pair<int, int>, int> &mp = items[itemId];
        auto it = mp.begin();
        if (it == mp.end()) return -1;
        return -1 * it->first.second;
    }
};

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem* obj = new AuctionSystem();
 * obj->addBid(userId,itemId,bidAmount);
 * obj->updateBid(userId,itemId,newAmount);
 * obj->removeBid(userId,itemId);
 * int param_4 = obj->getHighestBidder(itemId);
 */