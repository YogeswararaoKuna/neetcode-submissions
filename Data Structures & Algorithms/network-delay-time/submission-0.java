class Pair{
    int node;
    int weight;
    Pair(int node,int weight)
    {
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int edge[]:times)
        {
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adj.get(u).add(new Pair(v,w));
        }
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.offer(new Pair(k,0));
        while(!pq.isEmpty())
        {
            Pair curr=pq.poll();
            int node=curr.node;
            int currDist=curr.weight;
            if(currDist>dist[node])
            {
                continue;
            }
            for(Pair neighbour:adj.get(node))
            {
                int next=neighbour.node;
                int edgeWeight=neighbour.weight;
                if(dist[node]+edgeWeight<dist[next])
                {
                    dist[next]=dist[node]+edgeWeight;
                    pq.offer(new Pair(next,dist[next]));
                }
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int x=1;x<=n;x++)
        {
            ans=Math.max(ans,dist[x]);
        }
        if(ans==Integer.MAX_VALUE)
        {
            return -1;
        }
        return ans;
    }
}