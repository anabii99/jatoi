import java.io.PrintWriter;
import java.util.Scanner;

class Main {
    public static int cycleLength(int n) {
        int length = 1;
        while (n != 1) {
            n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
            length++;
        }
        return length;
    }

    public static int maxCycleLength(int i, int j) {
        int maxCycle = 0;
        for (int n = i; n <= j; n++) {
            maxCycle = Math.max(maxCycle, cycleLength(n));
        }
        return maxCycle;
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);
        while (in.hasNextInt()) {
            int i = in.nextInt(), j = in.nextInt(), from = Math.min(i, j), to = Math.max(i, j), max = 0;
            for ( int n = from; n <= to; n++) {
                max = Math.max(max, cycleLength(n));
            }
            out.printf("%d %d %d\n", i, j, max);
        }
    }
}

