import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.*;

public class Top3Words {

//    Write a function that, given a string of text
//    (possibly with punctuation and line-breaks),
//    returns an array of the top-3 most occurring words, in descending order of the number of occurrences.

//    Assumptions:
//    A word is a string of letters (A to Z) optionally containing one or more apostrophes (') in ASCII. (No need to handle fancy punctuation.)
//    Matches should be case-insensitive, and the words in the result should be lowercased.
    public static void main(String[] args) {
//        top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e");
//        top3("a a a  b  c c    d d d d  e e e e e");
//        top3( "  //wont won't won't " );
//        top3("  , e   .. ");"
//        top3("  '  ");
//        top3("  l'' as' as sa ' / as'");
//        top3("HWe HWe_HWe bfGOuXmS HWe.bfGOuXmS HWe!bfGOuXmS HWe bfGOuXmS HWe,bfGOuXmS_bfGOuXmS HWe HWe HWe-HWe!HWe;HWe HWe!bfGOuXmS.HWe;HWe bfGOuXmS HWe bfGOuXmS HWe?HWe HWe-HWe?HWe HWe HWe:HWe:HWe?HWe?HWe bfGOuXmS-HWe HWe");
        singleToneClass s = singleToneClass.getInstance();
        s.setData("ss");
        s.setData("s");
        float v = Float.valueOf("2.2");
        System.out.println(s.s);
    }

    public static List<String> top3(String s) {
        System.out.println(s);
        s = s.trim();
        List<String> strings = Arrays.stream(s.split("\\s+"))
                .map(Top3Words::removeNonLetterSymb)
                .filter(str -> !str.equals("") && !str.equals("'"))
                .collect(Collectors.toList());

        Map<String, Integer> map = new LinkedHashMap<>();

        for (String string: strings
             ) {
            map.put(string,  map.containsKey(string) ? map.get(string) +1 : 1);
        }

        map.values().stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        Stream<Map.Entry<String,Integer>> sorted =
                map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<String> result = sorted.limit(3).distinct().map(set -> set.getKey()).collect(Collectors.toList());
//        List<String> result = new ArrayList<>();
//        int len = Math.min(map.size(),3);
////        for (int i = 0; i <  len; i++) {
////            String val = map.keySet().iterator().next();
////            result.add(val);
////        }
//        int count = 0;
//        Iterator<String> iterator = map.keySet().iterator();
//        while (iterator.hasNext()) {
//            result.add(iterator.next());
//            count++;
//            if (count > len-1) break;
//        }

        return result;
    }

    public static String removeNonLetterSymb(String s) {
        s = s.toLowerCase();
        s = s.trim();
        s.chars().forEach(i -> System.out.println((char)i));
//        s = s.replaceAll("[^A-Za-z']", "");
//        if (s.chars().ma)
        if (s.chars().mapToObj(i -> (char)i).noneMatch(Character::isLetter)) return "";
        if(s.chars().mapToObj(i -> (char)i).allMatch(Character::isLetter)) return "";
        return s.toLowerCase();
    }


}
