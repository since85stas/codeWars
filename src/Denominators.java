public class Denominators {

    public static void main(String[] args) {
        convertFrac(new long[][] { {1, 2}, {1, 3}, {10, 40} });
    }

    public static String convertFrac(long[][] lst) {
        // your code
        for (int i = 0; i < lst[0].length; i++) {
            System.out.println(1);
            for (long j = lst[i][0]; j > 1 ; j++) {
                if (lst[i][1]%j ==0) {
                    lst[i][0] /=lst[i][0]/j;
                    lst[i][1] /=lst[i][1]/j;
                }
            }
        }
        return "";
    }

}
