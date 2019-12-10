package permutationSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: pointer
 * @date: Created on 2019/12/10
 */
class Solution {

    private int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            used[i] = false;
        }
        List<String> numStr = new ArrayList<>();
        return getPermutationHelper(n, k, n, nums, used, numStr);
    }

    private String getPermutationHelper(int n, int k, int high,
                                        int[] nums, boolean[] used,
                                        List<String> numStr) {
        if (high == 0) {
            StringBuilder sb = new StringBuilder();
            for (String str : numStr) {
                sb.append(str);
            }
            return sb.toString();
        }
        int factorialRes = factorial[high-1];
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            if (factorialRes < k) {
                k -= factorialRes;
                continue;
            }
            numStr.add(nums[i] + "");
            used[i] = true;
            return getPermutationHelper(n, k, high-1, nums, used, numStr);
        }
        return "";
    }
}
