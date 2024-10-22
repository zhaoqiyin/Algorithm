package base.class08;

/**
 * 规定1和A对应、2和B对应、3和C对应...
 * 吧呢图个数字字符串比如“111”，就可以转化成“AAA”、“KA”、“AK”。
 * 给定一个只有数字字符组成的字符串str，返回有多少种转化结果
 */
public class Code06_ConvertToLetterString {

    public static int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    // i之前的位置，如何转化已经做过决定了
    // i...有多少种转化的结果
    public static int process(char[] str, int i) {
        if (i == str.length) {
            return 1;
        }
        if (str[i] == '0') {
            return 0;
        }
        if (str[i] == '1') {
            int res = process(str, i + 1); // i自己作为单独的部分，后续有多少种方法
            if (i + 1 < str.length) {
                res += process(str, i + 2); // (i和i+1)作为单独的部分，后续有多少种方法
            }
            return res;
        }
        if (str[i] == '2') {
            int res = process(str, i + 1); // i自己作为单独的部分，后续有多少种方法
            // (i和i+1)作为单独的部分并且没有超过26，后续有多少种方法
            if (i + 1 < str.length && str[i + 1] >= '0' && str[i + 1] <= '6') {
                res += process(str, i + 2);
            }
            return res;
        }
        // str[i] == '3' ~ '9'
        return process(str, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(number("11111"));
    }
}
