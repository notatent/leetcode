package com.mean.world.a169_majorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tent on 2020-10-12 12:14
 */
public class Solution {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> all = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            Integer count = all.get(nums[i]);
            if (count == null) count = 0;
            all.put(nums[i], count + 1);
        }
        for (int num : nums) {
            if (all.get(num) > nums.length / 2) return num;
        }
        return 0;
    }

    /**
     * http://www.cs.utexas.edu/~moore/best-ideas/mjrty/
     * <p>
     * 从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
     */
    public int optimize(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            } else if (nums[i] == major) {
                count++;
            } else count--;
        }
        return major;
    }
}
