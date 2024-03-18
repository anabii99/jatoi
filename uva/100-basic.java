import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int x = in.nextInt(), y = in.nextInt();
            int min = Math.min(x, y);
            int max = Math.max(x, y);
            int a = 0;
            for (int i = min; i <= max; i++) {
                int temp = 1;
                for (int j = i; j != 1;) {
                    if (j % 2 == 0)
                        j = j / 2;
                    else
                        j = j * 3 + 1;
                    temp++;
                }

                if (temp > a)
                    a = temp;
            }

            System.out.println(x + " " + y + " " + a);
        }
    }
}