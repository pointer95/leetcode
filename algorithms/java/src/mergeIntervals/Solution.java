package mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * source: https://leetcode-cn.com/problems/merge-intervals/
 * date: 2019/11/25
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        for (int[] interval : intervals) {
            int size = res.size();
            if (size > 0 && res.get(size-1)[1] >= interval[0]) {
                res.get(size-1)[1] = Math.max(interval[1], res.get(size-1)[1]);
            } else {
                res.add(interval);
            }
        }
        return res.toArray(new int[0][]);
    }
}
