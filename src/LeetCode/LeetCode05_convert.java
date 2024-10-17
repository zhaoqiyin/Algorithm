package LeetCode;

/**
 * Z字形变换
 * 方法：
 * 假如numsRows是3
 * 新建一个长度为3数组arr，arr[0]记录第0行的字符串，arr[1]记录第1行的字符串...
 * 最后将数组中的元素拼接成一个字符串
 * 因为是Z行变换，需要设置一个标记位flag，和一个变量m m的变化范围是0-2-0-2，每次到0或者2.flag取反
 */
public class LeetCode05_convert {

    public static void main(String[] args) {
        System.out.println("123");
        String s = "AB";
        System.out.println(convert(s, 1));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        String[] arr = new String[numRows];
        int len = chars.length;
        boolean flag = true;
        int m = 0;
        for (int i = 0; i < numRows; i++) {
            arr[i] = "";
        }
        for (char aChar : chars) {
            if (flag) {
                arr[m] = arr[m] + aChar;
                if (m == numRows - 1) {
                    flag = false;
                    m--;
                } else {
                    m++;
                }
            } else {
                arr[m] = arr[m] + aChar;
                if (m == 0) {
                    flag = true;
                    m++;
                } else {
                    m--;
                }
            }
        }
        for (int i = 0; i < numRows; i++) {
            System.out.println(arr[i]);
            result.append(arr[i]);
        }
        return result.toString();
    }
}
