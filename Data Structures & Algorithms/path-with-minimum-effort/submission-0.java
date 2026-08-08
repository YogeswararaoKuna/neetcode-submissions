class Cell {
    int row;
    int col;
    int weight;

    Cell(int row, int col, int weight) {
        this.row = row;
        this.col = col;
        this.weight = weight;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        // Minimum effort required to reach each cell
        int[][] dist = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        // Min Heap based on effort
        PriorityQueue<Cell> pq =
            new PriorityQueue<>((a, b) -> a.weight - b.weight);

        pq.offer(new Cell(0, 0, 0));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            Cell curr = pq.poll();

            int row = curr.row;
            int col = curr.col;
            int currEffort = curr.weight;

            // Ignore outdated entry
            if (currEffort > dist[row][col]) {
                continue;
            }

            // Destination reached
            if (row == m - 1 && col == n - 1) {
                return currEffort;
            }

            // Visit 4 neighbours
            for (int i = 0; i < 4; i++) {

                int nr = row + dr[i];
                int nc = col + dc[i];

                // Boundary check
                if (nr < 0 || nr >= m ||
                    nc < 0 || nc >= n) {
                    continue;
                }

                // Difference between current and next cell
                int diff = Math.abs(
                    heights[row][col] - heights[nr][nc]
                );

                // Maximum effort along this path
                int newEffort = Math.max(
                    currEffort,
                    diff
                );

                // Relaxation
                if (newEffort < dist[nr][nc]) {

                    dist[nr][nc] = newEffort;

                    pq.offer(
                        new Cell(nr, nc, newEffort)
                    );
                }
            }
        }

        return 0;
    }
}