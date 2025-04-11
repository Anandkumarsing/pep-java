//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
    public:
    int maximumSumSubarray(vector<int>& arr, int k) {
        int sum = 0;
        for(int i= 0;i<k;i++){
            sum +=arr[i];
        }
        int j =0;
        int ans = sum;
        for(int i=k;i<arr.size();i++){
              sum = sum +arr[i]-arr[j];
              ans = max(ans,sum);
              j++;
        }
        return ans;
    }
};


//{ Driver Code Starts.
int main() {
    string ts;
    getline(cin, ts);
    int t = stoi(ts);
    while (t--) {

        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        string ks;
        getline(cin, ks);
        int k = stoi(ks);
        Solution ob;
        int ans = ob.maximumSumSubarray(arr, k);
        cout << ans << "\n";
        cout << "~" << endl;
    }
    return 0;
}
// } Driver Code Ends