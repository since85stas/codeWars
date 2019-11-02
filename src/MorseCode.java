import sun.font.CreatedFontTracker;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MorseCode {
    public static void main(String[] args) {
//        modrseDecomp(" .");
//        modrseDecomp(".... . -.--   .--- ..- -.. .");
//        directionsReduce(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"});
        pigIt("Hello World");
    }

    public static String modrseDecomp(String string) {
        String[] array = string.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals("")){
                builder.append(array[i]);
            } else {
                builder.append(" ");
                i++;
            }
        }
        return builder.toString();
    }

    public static String[] directionsReduce(String[] array) {

//        Arrays.stream(array).reduce(new BinaryOperator<String>() {
//            @Override
//            public String apply(String s, String s2) {
//                return null;
//            }
//        })
        List<String> dirList = new ArrayList<>(Arrays.asList(array));
        for (int i = 1; i < dirList.size() ; i++) {
            if ( checkDirIsOpposite(dirList.get(i-1),dirList.get(i)) ) {
                dirList.remove(i);
                dirList.remove(i-1);
                i=0;
            }
        }
        return dirList.stream().toArray(String[]::new);
    }

    public static boolean checkDirIsOpposite(String dir, String newDir) {
        switch (dir) {
            case "NORTH":
                if (newDir.equals("SOUTH")) return true;
                break;
            case "SOUTH":
                if (newDir.equals("NORTH")) return true;
                break;
            case "EAST":
                if (newDir.equals("WEST")) return true;
                break;
            case "WEST":
                if (newDir.equals("EAST")) return true;
                break;
        }
        return false;
    }

    public static String[] dirReduc(String[] arr) {
        final Stack<String> stack = new Stack<>();

        for (final String direction : arr) {
            final String lastElement = stack.size() > 0 ? stack.lastElement() : null;

            switch(direction) {
                case "NORTH": if ("SOUTH".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
                case "SOUTH": if ("NORTH".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
                case "EAST":  if ("WEST".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
                case "WEST":  if ("EAST".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
            }
        }
        return stack.stream().toArray(String[]::new);
    }

    public static String pigIt(String str) {
        // Write code here
        String resultStr = "";
        for (String string : str.trim().split(" ")
                ) {
            if ( string.matches("[a-zA-Z]+") ) {
                StringBuilder builder = new StringBuilder(string);
                builder.append(builder.charAt(0)).append("ay");
                builder.deleteCharAt(0);
                resultStr += builder.toString() + " ";
            } else resultStr += string;
        }
        return resultStr.trim();
    }

    public class PigLatin {
        public  String pigIt(String str) {
            return Arrays.stream(str.trim().split(" "))
                    .map(v -> v.matches("[a-zA-Z]+") ? v.substring(1).concat(v.substring(0, 1)).concat("ay") : v)
                    .collect(Collectors.joining(" "));
        }
    }
}
