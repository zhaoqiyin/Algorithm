package base.class07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个字符串数组，拼接成最小的字典序
 */
public class Code02_LowestLexicography {

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] str = {"jibw", "ji", "jp", "bw", "jibw"};
        System.out.println(lowestString(str));
    }
}
