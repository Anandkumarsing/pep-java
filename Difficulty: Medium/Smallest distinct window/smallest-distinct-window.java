//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


 class Solution {
    public int findSubString( String S) {
        HashSet<Character> st=new HashSet<>();
        for(int i=0;i<S.length();i++)st.add(S.charAt(i));
          HashMap<Character,Integer> hp=new HashMap<>();
        int l=0;
        int r=0;
        int n=S.length();
        int maxi=Integer.MAX_VALUE;
        while( r < n){
            if(hp.containsKey(S.charAt(r))){
                hp.put(S.charAt(r),hp.getOrDefault(S.charAt(r),0)+1);
            }
            else{
                hp.put(S.charAt(r),1);
            }
            if(hp.size() == st.size()){
                while(hp.size() == st.size()){
                    maxi=Math.min(maxi,r-l+1);
                    char ch=S.charAt(l);
                    int count=hp.get(ch);
                    count--;
                    if(count == 0){
                        hp.remove(ch);
                    }
                    else{
                        hp.put(ch,count);
                    }
                    l++;
                }
            }
            r++;
        }
        if(maxi == Integer.MAX_VALUE)return -1;
        else return maxi;
    }
}






