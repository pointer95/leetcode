package climbingStairs;

import java.util.HashMap;

/**
 * source: https://leetcode-cn.com/problems/climbing-stairs/
 * date: 2019-08-11
 */
class Solution {

    private HashMap<Integer, Integer> map;

    public Solution() {
        map = new HashMap<>();
    }

    public int climbStairs(int n) {
        return climb(n);
    }

    private int climb(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        map.put(n, climb(n-1) + climb(n-2));
        return map.get(n);
    }
}
