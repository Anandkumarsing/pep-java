#User function Template for python3

class Solution:
    def helper(self,node,vis,adj,ans):
        vis[node] = 1
        ans.append(node)
        
        for neighbor in adj[node]:
            if not vis[neighbor]:
                self.helper(neighbor,vis,adj,ans)
        
    def dfs(self, adj):
        ans = []
        vis = [0] * len(adj)
        vis[0] = 1 
        start = 0
        self.helper(start,vis,adj,ans)
        
        return ans

#{ 
 # Driver Code Starts
import sys
#Position this line where user code will be pasted.


def main():
    tc = int(sys.stdin.readline().strip())

    for _ in range(tc):
        V = int(sys.stdin.readline().strip())
        adj = []

        for _ in range(V):
            input_line = sys.stdin.readline().strip()
            node = list(map(int, input_line.split())) if input_line else []
            adj.append(node)

        obj = Solution()
        ans = obj.dfs(adj)
        print(" ".join(map(str, ans)))
        print("~")


if __name__ == "__main__":
    main()

# } Driver Code Ends