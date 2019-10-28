package multiplyStrings;

/**
 * source: https://leetcode-cn.com/problems/multiply-strings/
 * date: 2019/10/28
 */
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String res = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                sb.append("0");
            }
            int y = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int z = x * y + carry;
                sb.append(z % 10);
                carry = z / 10;
            }
            if (carry > 0) {
                sb.append(carry);
            }
            res = addStrings(res, sb.reverse().toString());
        }
        return res;
    }

    private String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int z = x + y + carry;
            builder.append(z % 10);
            carry = z / 10;
        }
        if (carry > 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }
}
