package com.mean.world.a242_validAnagram;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
class Solution {

    public static void main(String[] args) {
        String s="anagram";
        String t="nagaram";
        new Solution().isAnagram(s,t);
    }

    public boolean isAnagram(String s, String t) {
        return solution1(s, t);
    }

    /**
     * using two arrays, length 26 indicate lowercase char of a-z
     */
    private boolean solution1(String s, String t) {
        boolean result = true;
        int[] left = new int[26];
        int[] right = new int[26];
        for (int i = 0; i < s.length(); i++) {
            left[indexOfString(s.charAt(i))]++;
        }
        for (int j = 0; j < t.length(); j++) {
            right[indexOfString(t.charAt(j))]++;
        }
        for (int k = 0; k < left.length; k++) {
            if (left[k] != right[k]) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * using one arrays, length 26 indicate lower char of a-z
     * when s in the array then index of array ++
     * when t in the array then index of array --
     * if all of the values in the array equals 0, then t is an anagram of s
     * otherwise not
     */
    private boolean solution2(String s, String t) {
        Integer[] a2z = new Integer[26];
        return false;
    }

    /**
     * ASCII
     * A-Z 65-90，a-z 97-122
     */
    private int indexOfString(char alpha) {
        return alpha - 97;
    }
}
