//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases
        String str = br.readLine();
        int t = Integer.parseInt(str.trim());

        // Process each test case
        while (t-- > 0) {
            // Read the next line containing the array elements
            str = br.readLine();
            String[] tokens = str.trim().split("\\s+");

            // Convert the input strings to integers and store in an array
            ArrayList<Integer> list = new ArrayList<>();
            for (String token : tokens) {
                if (!token.isEmpty()) { // Ensure that the token is not empty
                    list.add(Integer.parseInt(token));
                }
            }

            // Convert ArrayList to int[] for processing
            int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

            // Create an instance of Solution and compute the minimum energy
            Solution ob = new Solution();
            int result = ob.minCost(arr);

            // Output the result followed by a tilde as per the original C++ code
            System.out.println(result);
            System.out.println("~");
        }
    }
}


// } Driver Code Ends

// User function Template for Java
class Solution {
    int[] dp;

    public int minCost(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        dp = new int[n];
        for(int i=0;i<n;i++) dp[i] = -1;
        return helper(n - 1, height);
    }

    int helper(int i, int[] h) {
        if (i == 0) return 0;
        if (dp[i] != -1) return dp[i];

        int fs = Math.abs(h[i] - h[i - 1]) + helper(i - 1, h);
        int ss = Integer.MAX_VALUE;
        if (i > 1) {
            ss = Math.abs(h[i] - h[i - 2]) + helper(i - 2, h);
        }

        return dp[i] = Math.min(fs, ss);
    }
}
        
        
    

//{ Driver Code Starts.

// } Driver Code Ends