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
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int start = i, end = j;
            if (i > j) {
                int temp = i;
                i = j;
                j = temp;
            }
            int maxCycle = maxCycleLength(i, j);
            System.out.println(start + " " + end + " " + maxCycle);
        }
    }
}

