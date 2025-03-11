//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    string reverseString(string& s) {
        int i =0;
        int e =s.size()-1;
        while(i<e){
            swap(s[i],s[e]);
            i++;
            e--;
        }
        return s;
    }
};



//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution ob;
        cout << ob.reverseString(s) << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}

// } Driver Code Ends