

QUESTION: https://leetcode.com/problems/bulls-and-cows/

// MY SOLUTION:
class Solution {
    public String getHint(String secret, String guess) {
        char sec[] = secret.toCharArray();
        int secCount[] = new int[10];
        char gue[] = guess.toCharArray();
        int gueCount[] = new int[10];
        int bull=0;
        int cow=0;
        for(int i=0; i<sec.length; ++i)
        {
            if(sec[i] == gue[i]) bull++;
            else{
                secCount[sec[i]-'0']++;
                gueCount[gue[i]-'0']++;
            }
        }
        for(int i=0; i<10; ++i)
        {
            cow+=Math.min(secCount[i],gueCount[i]);
        }
        return bull+"A"+cow+"B";
    }
}

// COMMUNITY SOLUTION:

public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    int[] numbers = new int[10];
    for (int i = 0; i<secret.length(); i++) {
        if (secret.charAt(i) == guess.charAt(i)) bulls++;
        else {
            if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
            if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
        }
    }
    return bulls + "A" + cows + "B";
}