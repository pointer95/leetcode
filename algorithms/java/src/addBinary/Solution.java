package addBinary;

/**
 * source: https://leetcode-cn.com/problems/add-binary/
 * @author: pointer
 * @date: Created on 2019/12/16
 */
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len1 = a.length(), len2 = b.length();
        int carry = 0;
        while (len1-1 >= 0 || len2-1 >= 0) {
            int num1 = len1-1 >= 0 ? a.charAt(len1-1)-'0' : 0;
            int num2 = len2-1 >= 0 ? b.charAt(len2-1)-'0' : 0;
            int sum = num1 + num2 + carry;
            sb.append(sum % 2);
            carry = sum / 2;
            len1--;
            len2--;
        }
        sb.append(carry == 1 ? carry : "");
        return sb.reverse().toString();
    }
}
