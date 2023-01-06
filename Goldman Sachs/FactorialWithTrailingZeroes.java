

// QUESTION: https://leetcode.com/problems/factorial-trailing-zeroes/

// main idea: we only need to count the number of 5 because ample amount of 2s are present to multiply the 5 with 2 and make it 10. 
                // but since we have 25 = 5*5  and 125 = 5*5*5 we have more number of 5 coming after we cross numbers with next power of 5 
                // hence the case to handle that too


class Solution {
    public int trailingZeroes(int n) {
        int count=0;
        int fivePower=5;
        while(n/fivePower != 0)
        {
            count+= (n/fivePower);
            fivePower*=5;
        }
        
        return count;
    }
}