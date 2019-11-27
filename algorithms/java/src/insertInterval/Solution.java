package insertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/insert-interval/
 * date: 2019/11/26
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length == 0) {
            return intervals;
        }
        List<int[]> res = new ArrayList<>();
        intervals = Arrays.copyOf(intervals, intervals.length+1);
        intervals[intervals.length-1] = newInterval;
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        for (int[] interval : intervals) {
            int size = res.size();
            if (size > 0 && res.get(size-1)[1] >= interval[0]) {
                res.get(size-1)[1] = Math.max(res.get(size-1)[1], interval[1]);
            } else {
                res.add(interval);
            }
        }
        return res.toArray(new int[0][]);
    }
}
