import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class test01 {
    public static void main(String[] args) {
        System.out.println("init");
        String num = "2 4 -1 6 10 11";
//        highAndLow(num);
//        persistant(26);
//        hasing("2323434dd");
//        int res = outliter(new int[]{3, 5, 8, 7, 11, 13});
//        getXO("ooCCxxXo");
//        sortOdd(new int[] {5, 3, 1, 8, 0});
        boolean is =isIntSimple(7);
        System.out.println();
    }

    public static String highAndLow(String numbers) {
        // Code here or
        Stream<String> stream = Arrays.stream(numbers.split(" "));
        System.out.println(stream.min(Comparator.comparingInt(Integer::parseInt)).get());

        stream = Arrays.stream(numbers.split(" "));
        System.out.println(stream.max(Comparator.comparingInt(Integer::parseInt)).get());
        int i =1;
        return "throw towel";
    }

    public static int persistant(long n) {
        String string = String.valueOf(n);
        Stream<String> stringStream = Arrays.stream(string.split("") );
        Stream<Integer> integerStream = stringStream.map(Integer::valueOf);
        int res = integerStream.reduce(1, (a,b) -> a*b);
        System.out.println(stringStream);

        int res2 = Arrays.stream(string.split("")).map(Integer::valueOf).reduce(1,(a,b) -> a*b);
        return 0;
    }

    public static String hasing(String string) {
        char [] arr = string.toCharArray();
        String str = arr.toString();
        return str;
    }

    public static int outliter (int[] array) {
        int[] arr1 = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arr1[i] = Math.abs(array[i]%2);
        }

        for (int i = 1; i < array.length-1; i++) {
            if (arr1[i] != arr1[i-1]) {
                if (arr1[i+1] != arr1[i]) {
                    return array[i];
                } else {
                    return array[i-1];
                }

            }
        }
        return -1;
    }

    public static boolean getXO(String string) {
        long xCount = Arrays.stream(string.split("")).filter( s -> s.equals("x") || s.equals("X") ).count();
        long oCount = Arrays.stream(string.split("")).filter( s -> s.equals("o") || s.equals("O") ).count();
        return xCount==oCount;
    }

//    static int oddLastPos = 0;

    public static int[] sortOdd(int[] array) {

        for (int j = 0; j < array.length-1; j++) {

            int oddIntPos = getNextOddNum(array,j);
            int oddInt = array[oddIntPos];
            for (int i = oddIntPos; i < array.length; i++) {
                if ((array[i] % 2 != 0) && (array[i] < oddInt)) {
                    int tmp = array[i];
                    array[i] = oddInt;
                    array[oddIntPos] = tmp;
                    oddInt = tmp;
                }
            }
        }

        Arrays.stream(array).forEach(s -> System.out.println(s));
        return array;
    }

    public static int getNextOddNum(int[] arr, int pos) {
        for (int i = pos; i < arr.length; i++) {
            if (arr[i]%2 != 0) {
                return i;
            }
        }
        return arr.length-1;
    }

    public static boolean isIntSimple(int numb) {
        int del = 0;
        for (int i = 1; i*i < numb ; i++) {
            if ((numb%i == 0)) {
                del ++;
                if (del>1) return false;
            }
        }
        return true;
    }

}
