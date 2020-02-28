import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        File f = new File ("input.txt");
        List<Long> list = new ArrayList();
        try {
            Scanner s = new Scanner (f);
            int lI = s.nextInt();

            if (lI == 1) {
                System.out.println(s.nextInt());
            } else {
                long val = s.nextInt() ;
                boolean isPrinted = false;
                for (int i = 1; i< lI; i++) {
                    long n = s.nextInt();
                    if ( n > val) {
                        if (!isPrinted) System.out.println(val);
                        val = n;
                        isPrinted = false;
                    } else {
                        if (!isPrinted) {
                            System.out.println(val);
                            isPrinted = true;
                        }
                    }
                }
                if (!isPrinted) System.out.println(val);
            }
        } catch (Exception e) {

        }

    }

    public static void brill(int[] array) {
        int max = 0;
        if (array.length == 1) {
            max = array[0];
        } else if (array.length > 1) {
            int count = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] == 1 ) {
                    count++;
                } else if ( array[i] == 0) {
                    if (count > max) max = count;
                    count = 0;
                }
            }

        }
        System.out.println(max);
    }
}
