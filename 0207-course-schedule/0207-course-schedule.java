class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length < 2) return true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] entry = prerequisites[i];
            if (!map.containsKey(entry[1])) {
                map.put(entry[1], new ArrayList<Integer>());
                map.get(entry[1]).add(entry[0]);
            } else {
                map.get(entry[1]).add(entry[0]);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            // int size = map.get(prerequisite[0]).size();
            indegrees[prerequisite[0]]++;
        }        
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }
        if (q.isEmpty()) return false;
        // int count = q.size();
        while(!q.isEmpty()) {
            int curr = q.poll();
            if(map.containsKey(curr)) {
                for(int entry: map.get(curr)) {
                    indegrees[entry]--;
                    if (indegrees[entry] == 0) {
                        q.add(entry);
                        // count++;
                    }
                }                 
            }

            // if(count == numCourses) return true; 

        }
        for (int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] != 0) return false;
        }
        return true;
    }
}