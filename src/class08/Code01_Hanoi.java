package class08;

/**
 * 汉诺塔问题
 * 打印n层汉诺塔从最左边移动到最右边的全部过程
 *
 * 想把第i个从from移动到to上，其他的杆为other
 * from to other
 *
 * 1. 1～i-1    from -> other
 * 2. i    from -> to
 * 3. 1~i-1    other -> to
 */
public class Code01_Hanoi {

    public static void hanoi(int n) {
        if (n > 0) {
            func(n, "左", "右", "中");
        }
    }

    // 1～i 圆盘 目标是from -> to, other是另外一个
    public static void func(int i, String start, String end, String other) {
        if (i == 1) { // base case
            System.out.println("Move 1 from " + start + "to" + end);
        } else {
            func(i - 1, start, other, end);
            System.out.println("Move " + i + " from " + start + "to" + end);
            func(i -1, other, end, start);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }
}
