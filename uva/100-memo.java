import java.io.PrintWriter;
import java.util.Scanner;

class Main {
    public static final int SIZE = 1000000;
    public static int[] cache = new int[SIZE];

    public static int rules(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return 3 * n + 1;
        }
    }

    public static int maxCycleLength(int n) {
        if (n == 1) {
            return 1;
        }

        if (n < SIZE && cache[(int) n] != 0) {
            return cache[(int) n];
        }

        int length = 1 + maxCycleLength(rules(n));

        if (n < SIZE) {
            cache[(int) n] = length;

        }

        return length;
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);
        while (in.hasNextInt()) {
            int i = in.nextInt(), j = in.nextInt(), from = Math.min(i, j), to = Math.max(i, j), max = 0;
            for ( int n = from; n <= to; n++) {
                max = Math.max(max, maxCycleLength(n));
            }
            out.printf("%d %d %d\n", i, j, max);
        }
    }
}
