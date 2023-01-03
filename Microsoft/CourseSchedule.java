

// QUESTION:https://leetcode.com/problems/course-schedule/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegree[] = new int[numCourses];
        for(int i=0; i<prerequisites.length; ++i)
            indegree[prerequisites[i][1]]++;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; ++i) if(indegree[i]==0) q.add(i);
        
        int cnt=0;
        
        while(!q.isEmpty())
        {
            Integer node = q.poll();
            cnt++;
            for(int i=0; i<prerequisites.length; ++i)
            {
                if(node == prerequisites[i][0])
                {
                    indegree[prerequisites[i][1]]--;
                    if(indegree[prerequisites[i][1]] == 0)
                        q.add(prerequisites[i][1]);
                }
                    
            }
        }
        return cnt == numCourses;
            
    }
}

