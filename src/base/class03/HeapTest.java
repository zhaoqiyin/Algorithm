package base.class03;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * PriorityQueue<> 默认是小根堆，可以增加比较器的方式实现大根堆
 */
public class HeapTest {
    public static class Acomp implements Comparator<Integer> {

        // 如果返回负数，认为第一个参数应该放在上面
        // 如果返回正数，认为第二个参数应该放在上面
        // 如果返回0，认为放在上面都行
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Acomp());
        heap.add(6);
        heap.add(9);
        heap.add(3);
        heap.add(2);
        heap.add(10);
        heap.add(5);

        while (!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");
        }
    }


}
