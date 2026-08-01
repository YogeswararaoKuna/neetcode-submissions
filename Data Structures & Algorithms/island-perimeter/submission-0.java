class Solution {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        boolean vist[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                return dfs(grid,i,j,vist);
                }
            }
        }
        return ans;
    }
    public int dfs(int[][] grid,int i,int j,boolean vist[][])
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)
        {
            return 1;
        }
        if(grid[i][j]==0)
        {
            return 1;
        }
        if(vist[i][j] == true)
        {
            return 0;
        }
        vist[i][j]=true;
       return dfs(grid,i-1,j,vist)+dfs(grid,i+1,j,vist)+dfs(grid,i,j+1,vist)+dfs(grid,i,j-1,vist);
    }
}