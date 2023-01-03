

// QUESTION: https://leetcode.com/problems/rotate-function/

// MY SOLUTION: RESULTED IN TLE 45/58 TEST CASES

class Solution {
    public int maxRotateFunction(int[] nums) {
        int Max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; ++i)
        {
            int cur = func(nums,i);
            Max = Math.max(Max,cur);
        }
        return Max;
    }
    public int func(int nums[] , int ind)
    {
        int mul=1, ans=0, n=nums.length;
        for(int j=ind+1; j%n != ind; ++j,mul++)
        {
            ans+=(nums[j%n]*mul);
        }
        return ans;
    }
        
}