package com.huststl.year18.nov.day17;


//最长回文字串 难度（medium)
public class Main005 {

    //解法1

    public String longestPalindrome01(String s ){

        if(s.length() < 2)
            return s;

        int n = s.length(),maxLen = 0,start = 0;

        for(int i = 0;i<n-1;i++){
            searchPalindrome01(s,i,i,start,maxLen);
            searchPalindrome01(s,i,i+1,start,maxLen);
        }
        return s.substring(start,maxLen);
    }

    public void searchPalindrome01(String s, int left, int right, int start, int maxLen) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            --left;
            ++right;
        }

        if(maxLen < right - left -1){

            start = left +1;
            maxLen = right - left -1;
        }
    }

    //解法2

    /*

    动态规划：

            （一般含“最XX”等优化词义的题意味着都可以动态规划求解），时间复杂度O(n^2)，空间复杂度O(n^2)。
             形如"abba", "abbba"这样的字符串，如果用dp[i][j]表示从下标i到j之间的子字符串所构成的回文子串的长度，则有：
             dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
    初始化：
             奇数个字符：dp[i][i] = 1; 偶数个字符：dp[i][i+1] = 1
    若长度相同，返回最后一个子串
    */
    public String longestPalindrome02(String s) {
        if (s == null || s.length() <= 1)
            return s;
        int n = s.length();
        char[] cs = s.toCharArray();
        int max = 1;
        int maxIndex = 0;
        boolean dp[][] = new boolean[n][n];
        // 初始化一个字母
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            maxIndex = i;
        }
        // 初始化两个相同的字母"aa"
        for (int i = 0; i < n - 1; i++)
            if (cs[i] == cs[i + 1]) {
                dp[i][i + 1] = true;
                // 返回最后一为2的子串
                max = 2;
                maxIndex = i;
            }
        // 从长度3开始操作, (aba)ba, a(bab)a, ab(aba)
        for (int len = 3; len <= n; len++)
            for (int i = 0; i < n - len + 1; i++) {
                // j为从i~i + len - 1下标，长度为len
                int j = i + len - 1;
                // 字符相同，并且内部长度是回文
                if (cs[i] == cs[j] && dp[i + 1][j - 1]) {
                    max = len;
                    // 因为长度递增，如果之后的的能进入这里都是比之前长的，
                    // 所以不需要判断大小
                    maxIndex = i;
                    dp[i][j] = true;
                }
            }
        return s.substring(maxIndex, maxIndex + max);
    }
}
