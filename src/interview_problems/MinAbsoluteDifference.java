package interview_problems;

import java.util.ArrayList;
import java.util.List;

public class MinAbsoluteDifference {

    static int minDiff;
    static int totalSum;
    static List<List<Integer>> graph;
    static int[] towns;
    static boolean[] visited;

    public static int function(int N, int[] townsArr, int[][] roads) {
        towns = townsArr;
        graph = new ArrayList<>();
        visited = new boolean[N];
        minDiff = Integer.MAX_VALUE;
        totalSum = 0;

        // Build graph
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
            totalSum += towns[i];
        }

        for (int[] road : roads) {
            int u = road[0] - 1; // convert to 0-based index
            int v = road[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // DFS from node 0
        dfs(0);

        return minDiff;
    }

    private static int dfs(int node) {
        visited[node] = true;
        int subTreeSum = towns[node];

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                int childSum = dfs(neighbor);

                // Try cutting this edge
                int diff = Math.abs(totalSum - 2 * childSum);
                minDiff = Math.min(minDiff, diff);

                subTreeSum += childSum;
            }
        }
        return subTreeSum;
    }

    // Optional main for testing
    public static void main(String[] args) {
        System.out.println(function(4, new int[]{10,20,10,30},
                new int[][]{{1,2},{2,3},{3,4}})); // 10

        System.out.println(function(3, new int[]{5,10,15},
                new int[][]{{1,2},{2,3}})); // 0

        System.out.println(function(2, new int[]{10,20},
                new int[][]{{1,2}})); // 10
    }
}
