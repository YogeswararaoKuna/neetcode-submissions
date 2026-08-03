class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges)
        {
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int vist[]=new int[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(vist[i]==0)
            {
                count++;
                dfs(adj,vist,i);
            }
        }
        return count;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,int vist[],int i)
    {
        vist[i]=1;
        for(int x:adj.get(i))
        {
            if(vist[x]==0)
            {
                dfs(adj,vist,x);
            }
        }
    }
}
