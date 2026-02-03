class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0;i<prerequisites.length; i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] indegree = new int[numCourses];
        for(int i = 0;i < numCourses; i++){
            for(int it : adjList.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<numCourses; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            topo.add(node);
            q.poll();
            for(int it : adjList.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(topo.size()==numCourses){
            int[] ans = new int[topo.size()];
            for(int i = 0;i<topo.size(); i++){
                ans[i] = topo.get(i);
            } 
            return ans;
        }
        int[] ans = {};
        return ans;
    }
}