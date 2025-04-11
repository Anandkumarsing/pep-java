//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		
System.out.println("~");
}
	}
}


// } Driver Code Ends


class Solution
{
    static class Node{
        int val,row,col;
        Node (int val,int row,int col){
            this.val=val;
            this.row=row;
            this.col=col;
        }
    }
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
       PriorityQueue<Node> minHeap=new PriorityQueue<>(Comparator.comparingInt(a->a.val));
       ArrayList<Integer> res=new ArrayList<>();
       for(int i=0;i<k;i++){
           minHeap.add(new Node(arr[i][0],i,0));
       }
       while(!minHeap.isEmpty()){
           Node current=minHeap.poll();
           res.add(current.val);
           int nextCol=current.col+1;
           if(nextCol<k){
               minHeap.add(new Node(arr[current.row][nextCol],current.row,nextCol));
           }
       }
       return res;
    }
}
//User function Template for Java


