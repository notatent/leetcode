package com.mean.world.a015_3Sum;

import java.util.*;

/**
 * Created by tent on 2020-10-12 15:51
 */
public class Solution {

    public List<List<Integer>> twoPointer(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;// NOTE
            int target = -nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (nums[j] + nums[k] < target) {
                    j++;// ONLY move j make "nums[j] + nums[k] == target" possible, when move k "nums[j] + nums[k] always< target"
                } else {
                    k--;
                }

            }
        }
        return res;
    }

    public List<List<Integer>> hashingBased(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int curr_sum = sum - nums[i];
            Set<Integer> m = new TreeSet();
            for (int j = i + 1; j < nums.length; j++) {
                if (m.contains(curr_sum - nums[j])) {
                    /*double max = Math.max(x, Math.max(y, z));
                    double min = Math.min(x, Math.min(y, z));
                    double mid = x + y + z - max - min;*/
                    // FIXME duplicate List<Integer>
                    res.add(Arrays.asList(nums[i], nums[j], curr_sum - nums[j]));
                }
                m.add(nums[j]);
            }
        }
        return res;
    }
}
