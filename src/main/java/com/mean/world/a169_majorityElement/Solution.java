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
}
