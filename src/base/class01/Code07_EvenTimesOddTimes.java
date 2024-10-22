package base.class01;

/**
 * 通过异或运算找出一个数组中只出现奇数次的一个数，其他数都出现了偶数次
 * 通过异或运算找出一个数组中只出现奇数次的2个数，其他数都出现了偶数次
 */
public class Code07_EvenTimesOddTimes {


    private static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int cur: arr) {
            eor ^= cur;
        }
        System.out.println(eor);
    }

    private static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int cur: arr) {
            eor ^= cur;
        }
        // eor = a ^ b
        // eor != 0
        // eor必然有一个位置上是1
        int rightOne = eor & (~eor + 1); // 提取出最右的1

        int onlyOne = 0; // eor'
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }
        System.out.println(eor + " " + (eor ^ onlyOne));
    }
}
