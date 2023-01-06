

// QUESTION:https://leetcode.com/problems/largest-divisible-subset/ 
// similar to largest increasing subsequence

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        ArrayList<Integer> answer = new ArrayList<>();
        int prev[] = new int[nums.length];
        int hash[] = new int[nums.length];
        Arrays.fill(prev,1);
        Arrays.sort(nums);
        hash[0]=0;
        int max=1;
        int lastIndex=0;
        for(int i=1; i<nums.length; ++i)
        {
            hash[i]=i;
            for(int j=i-1; j>=0; --j)
            {
                if(nums[i] % nums[j] == 0 && prev[i]<prev[j]+1)
                {
                    prev[i]=prev[j]+1;
                    hash[i]=j;
                }
            }
            if(prev[i] > max ) 
            {
                max=prev[i];
                lastIndex=i;
            }
        }
        // answer.add(nums[lastIndex]);
        // lastIndex=hash[lastIndex];
        while(hash[lastIndex] != lastIndex)
        {
            answer.add(nums[lastIndex]);
            lastIndex=hash[lastIndex];
        }
        answer.add(nums[lastIndex]);
        return answer;
            
    }
}

