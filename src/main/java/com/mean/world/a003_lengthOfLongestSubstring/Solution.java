package com.mean.world.a003_lengthOfLongestSubstring;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tent on 2019-11-04 15:39
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
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
}

//public class MainClass {
//    public static String stringToString(String input) {
//        return JsonArray.readFrom("[" + input + "]").get(0).asString();
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            String s = stringToString(line);
//
//            int ret = new Solution().lengthOfLongestSubstring(s);
//
//            String out = String.valueOf(ret);
//
//            System.out.print(out);
//        }
//    }
//}
