package base.class03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 比较器
 */
public class Code03_Comparator {

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    // 根据id升序的比较器
    public static class IdAscendingComparator implements Comparator<Student> {

        // 返回负数的时候，第一个参数排在前面
        // 返回正数的时候，第二个参数排在前面
        // 返回0的时候，谁在前面无所谓
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    // 根据id降序的比较器
    public static class IdDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    // 根据age升序的比较器
    public static class AgeAscendingComparator implements Comparator<Student> {

        // 返回负数的时候，第一个参数排在前面
        // 返回正数的时候，第二个参数排在前面
        // 返回0的时候，谁在前面无所谓
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

    // 根据age降序的比较器
    public static class AgeDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }
    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id: " + student.id + ", Age : " + student.age);
        }
    }

    public static class Acomp implements Comparator<Integer> {

        // 如果返回负数，认为第一个参数应该排在前面
        // 如果返回正数，认为第二个参数应该排在前面
        // 如果返回0，认为谁放前面都行
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5,4,3,2,7,9,1,0};
        Arrays.sort(arr, new Acomp());

        for (Integer item : arr) {
            System.out.print(item + " ");
        }

        System.out.println();

        Student student1 = new Student("A", 2, 20);
        Student student2 = new Student("A", 3, 21);
        Student student3 = new Student("A", 1, 22);

        Student[] students = new Student[] {student1, student2, student3};

        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);
    }
}
