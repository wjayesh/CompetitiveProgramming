class CourseScheduleIV_M {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Integer> adj[] = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int p[]: prerequisites){
            adj[p[0]].add(p[1]);
        }
        boolean[][] isReachable = new boolean[n][n];
        Deque<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            Arrays.fill(visited, false);
            queue.add(i);
            visited[i] = true;
            while(!queue.isEmpty()){
                int u = queue.remove();
                for(int v: adj[u]){
                    if(!visited[v]){
                        queue.add(v);
                        visited[v] = true;
                        isReachable[i][v] = true;
                    }
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for(int q[]: queries){
            ans.add(isReachable[q[0]][q[1]]);
        }
        return ans;
    }
}
