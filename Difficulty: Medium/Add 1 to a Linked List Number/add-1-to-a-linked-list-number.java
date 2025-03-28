//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends



class Solution {
    // Function to reverse the linked list
    public Node reverseList(Node head) {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Function to add 1 to the linked list number
    public Node addOne(Node head) {
        head = reverseList(head);  // Step 1: Reverse the linked list
        Node temp = head;
        int carry = 1;  // We need to add 1

        // Step 2: Traverse the list and handle carry
        while (temp != null) {
            temp.data += carry;
            if (temp.data < 10) {
                carry = 0;  // No more carry, break loop
                break;
            }
            temp.data = 0;  // If sum is 10, set current node to 0
            if (temp.next == null && carry == 1) {
                temp.next = new Node(1);  // Add new node if needed
                carry = 0;
                break;
            }
            temp = temp.next;
        }

        return reverseList(head);  // Step 3: Reverse again to restore order
    }
}



