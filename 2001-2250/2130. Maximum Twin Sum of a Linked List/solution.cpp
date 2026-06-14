#include <bits/stdc++.h>

using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution
{
public:
    ListNode *middleNode(ListNode *head)
    {
        ListNode *slow = head;
        ListNode *fast = head;
        while (fast->next && fast->next->next)
        {
            slow = slow->next;
            fast = fast->next->next;
        }
        return slow;
    }
    ListNode *reverse(ListNode *head)
    {
        ListNode *rev = NULL;
        ListNode *curr = head;
        while (curr)
        {
            ListNode *temp = curr;
            curr = curr->next;
            temp->next = rev;
            rev = temp;
        }
        return rev;
    }
    int pairSum(ListNode *head)
    {
        ListNode *middle = middleNode(head);
        ListNode *second = middle->next;
        middle->next = NULL;
        ListNode *first = reverse(head);
        int res = 0;
        while (first)
        {
            res = max(res, first->val + second->val);
            first = first->next;
            second = second->next;
        }
        return res;
    }
};