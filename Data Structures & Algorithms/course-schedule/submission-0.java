class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int edge[]:prerequisites)
        {
            int u=edge[0];
            int v=edge[1];
            adj.get(v).add(u);
        }
        int vist[]=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            if(vist[i]==0)
            {
                if(dfs(adj,vist,i))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int vist[],int i)
    {
        vist[i]=1;
        for(int n:adj.get(i))
        {
            if(vist[n]==0)
            {
                if(dfs(adj,vist,n))
                {
                    return true;
                }
            }
            if(vist[n]==1)
            {
                return true;
            }
        }
        vist[i]=2;
        return false;
    }
}