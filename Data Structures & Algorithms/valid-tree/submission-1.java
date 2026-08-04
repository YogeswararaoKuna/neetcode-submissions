class Solution {
    public boolean validTree(int n, int[][] edges) {
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
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{0,-1});
        vist[0]=1;
        while(!queue.isEmpty())
        {
            int curr[]=queue.poll();
            int node=curr[0];
            int parent=curr[1];
            for(int x:adj.get(node))
            {
                if(vist[x]==0)
                {
                    vist[x]=1;
                    queue.offer(new int[]{x,node});
                }
                else if(vist[x]==1)
                {
                    if(x != parent)
                    {
                        return false;
                    }
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(vist[i]==0)
            {
                return false;
            }
        }
        return true;
    }
}
