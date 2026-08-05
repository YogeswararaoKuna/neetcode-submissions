
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
        }

        // 0 = unvisited, 1 = visiting (on current path), 2 = fully visited
        int[] vist = new int[numCourses];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (vist[i] == 0) {
                if (hasCycle(adj, vist, i, st)) {
                    return new int[0]; // Cycle detected, impossible to complete
                }
            }
        }

        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = st.pop();
        }

        return ans;
    }

    private boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int[] vist, int i, Stack<Integer> st) {
        vist[i] = 1; // Mark as visiting

        for (int neighbor : adj.get(i)) {
            if (vist[neighbor] == 1) {
                return true; // Cycle found
            }
            if (vist[neighbor] == 0) {
                if (hasCycle(adj, vist, neighbor, st)) {
                    return true;
                }
            }
        }

        vist[i] = 2; // Mark as fully visited
        st.push(i);
        return false;
    }
}