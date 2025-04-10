//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            boolean ans =
                ob.hasTripletSum(nums, target); // Call the function and store result
            System.out.println(ans ? "true" : "false"); // Output the result
        }
    }
}

// } Driver Code Ends

class Solution {
    public static boolean hasTripletSum(int arr[], int target) {
        Arrays.sort(arr);
        int n =arr.length;
        for(int i =0;i<n-2 ;i++){
            int j = i+1;
            int k = n-1;
            while (j<k){
                int sum = arr[i]+ arr[j]+ arr[k];
                if(sum< target) j++;
                if(sum> target) k--;
                if(sum==target) return true;
            }
        }
        return false;
    }
}