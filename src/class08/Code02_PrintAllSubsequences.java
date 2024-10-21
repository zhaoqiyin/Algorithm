package class08;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印一个字符串的全部子序列（子集），包括空字符串
 */
public class Code02_PrintAllSubsequences {

    public static void printAllSubsequence(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    // 当前来到i位置，要和不要，走两条路
    // 之前的选择，所形成的结果是str
    public static void process(char[] str, int i) {
        if (i == str.length) {
            System.out.println(String.valueOf(str));
            return;
        }
        process(str, i + 1); // 要当前字符的路
        char tmp = str[i];
        str[i] = 0; // 疑问，str是char类型的数组啊，赋值为0就表示不要这个字符了？
        process(str, i + 1); // 不要当前字符的路
        str[i] = tmp;
    }

    public static void function(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0, new ArrayList<Character>());
    }

    // 当前来到i位置，要和不要，走两条路
    // res之前的选择，所形成的列表
    public static void process(char[] str, int i, List<Character> res) {
        if (i == str.length) {
            printList(res);
            return;
        }
        List<Character> resKeep = copyList(res);
        resKeep.add(str[i]);
        process(str, i+1, resKeep); // 要当前字符的路
        List<Character> resNoInclude = copyList(res);
        process(str, i+1, resNoInclude); // 不要当前字符的路
    }

    public static void printList(List<Character> res) {
        //...
    }

    public static List<Character> copyList(List<Character> list) {
        // 代码自己补
        return null;
    }
}
