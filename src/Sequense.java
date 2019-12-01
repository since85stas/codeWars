import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sequense {

    public static void main(String[] args) {
        String res =rangeExtraction(new int[] {15,17,20,22,25,27,30,31});
        //"-6,-3-1,3-5,7-11,14,15,17-20"
    }

    public static String rangeExtraction(int[] arr) {
        StringBuilder builder = new StringBuilder();
        int[] minArr = new int[arr.length-1];

        for (int i = 1; i < arr.length; i++) {
            minArr[i-1] = arr[i] - arr[i-1];
        }
        int element = arr[0];
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (minArr[i] != 1 && count == 0) {
                builder.append(arr[i] + ",");
            } else if  (minArr[i] != 1 && count > 1 ){
                builder.append(element + "-" + (element+count)+",");
                count =0;
            } else if  (minArr[i] != 1 && count > 0 && count <= 1 ){
                for (int j = 0; j <= count; j++) {
                    builder.append(element+j + ",");
                }
                count =0;
            } else if ( minArr[i] == 1 && count == 0){
                element = arr[i];
                count++;
            } else {
                count ++;
            }
        }
        if (count >  1 ) {
            builder.append((element) + "-" + (element + count));
        } else if (count ==0 && minArr[minArr.length-1] != 1) {
            builder.append(arr[arr.length-1]);
        } else if (count ==1 /*&& minArr[minArr.length-1] != 1*/) {
            builder.append(arr[arr.length-2] + ",");
            builder.append(arr[arr.length-1]);
        }

        if (builder.charAt(builder.length() -1) == ',') builder.deleteCharAt(builder.length()-1);
        return "";
    }


    static String rangeExtraction2(final int[] array) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            int rangeStart = array[i];
            sb.append(rangeStart);
            for (int j = i + 1; j <= array.length; j++) {
                if (j == array.length || array[j] != rangeStart + (j - i)) {
                    if (j - i >= 3) {
                        sb.append('-').append(array[j - 1]);
                        i = j - 1;
                    }
                    sb.append(',');
                    break;
                }
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
