package com.mean.world.a003_lengthOfLongestSubstring;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tent on 2019-11-04 15:39
 */
class Solution {
    public static void main(String[] args) {
        //System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        //System.out.println(new Solution().lengthOfLongestSubstring_200929("pwwkew"));
        System.out.println(new Solution().optimizeLengthOfLongestSubstring("abcabcbb"));
        //System.out.println(new Solution().lengthOfLongestSubstring_200929("au"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        List<String> list = new ArrayList();
        int longest = 1;
        int length = 1;
        list.add(s.substring(0, 1));
        for (int i = 1; i < s.length(); i++) {
            if (!list.contains(s.substring(i, i + 1))) {
                length++;
            } else {
                if (length > longest) {
                    longest = length;
                }
                int i1 = list.indexOf(s.substring(i, i + 1));
                length = length - i1;
                for (int j = 0; j <= i1; j++) {
                    list.remove(0);
                }
            }
            list.add(s.substring(i, i + 1));
        }
        return length > longest ? length : longest;
    }


    public int lengthOfLongestSubstring_200929(String s) {
        if (s == null || s.length() == 0) return 0;
        List<Character> longest = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (longest.contains(s.charAt(i))) {
                int index = longest.indexOf(s.charAt(i));
                for (int j = 0; j <= index; j++) {
                    longest.remove(0);
                }
            }
            longest.add(s.charAt(i));
            if (longest.size() > max) max = longest.size();
        }
        return max;
    }

    /**
     * solution refer: lt3.png
     */
    public int optimizeLengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            index[s.charAt(j)] = j + 1;
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

}

