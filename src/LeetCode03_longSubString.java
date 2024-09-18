import java.util.HashSet;

public class LeetCode03_longSubString {
    public static void main(String[] args) {
        String s = "asjrgapa";
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            set.clear();
            for (int j = i; j < length; j++) {
                char c = charArray[j];
                if (set.contains(c)) {
                    set.clear();
                    break;
                }
                set.add(c);
                maxLength = Math.max(maxLength, set.size());
            }
        }

//        for (char c : s.toCharArray()) {
//            if (set.contains(c)) {
//                set.clear();
//            }
//            set.add(c);
//            maxLength = Math.max(maxLength, set.size());
//        }

        System.out.println(maxLength);
    }
}
