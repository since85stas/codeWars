import java.util.*;

public class Anagramas {
    public static void main(String[] args) {
        int b = isAngramsHash(null,null);
        b = isAngramsHash("asdfg","asdf");
        b = isAngramsHash("aaaa","aaaa");
        b = isAngramsHash("aasdf","assdf");
        b = isAngramsHash("1", "");
    }

    public static int isAngramsHash(String s1, String s2) {
//        s1.toLowerCase();
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        for (String c: s1.split("")
             ) {
            Integer num = map1.get(c);
            map1.put(c, num == null ? 1 : ++num);
        }

        for (String c: s2.split("")
        ) {
            Integer num = map2.get(c);
            map2.put(c, num == null ? 1 : ++num);
        }

        if (map1.size() == map2.size() && map1.equals(map2)) return 1;


        else return 0;
    }

    public static boolean isAnagramas(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        s1 = String.valueOf(c1);
        s2 = String.valueOf(c2);

        return (s1.equals(s2));
    }

    public static int isAnagramasI(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        s1 = String.valueOf(c1);
        s2 = String.valueOf(c2);

        return (s1.equals(s2) ? 1 : 0);
    }

    public static boolean isAnagramas2(String s1, String s2) {
        if ( s1 != null && s2 != null  && s1.length() == s2.length()) {
            List<String> l1 = Arrays.asList(s1.split(""));
            List<String> l2 = Arrays.asList(s2.split(""));
            return l1.containsAll(l2) && l2.containsAll(l1);
        } else {
            return false;
        }
    }
}
