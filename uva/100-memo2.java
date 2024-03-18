import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Integer> sequenceLengths = new HashMap<>();
        
        while (in.hasNextInt()) {
            int x = in.nextInt(), y = in.nextInt();
            int min = Math.min(x, y);
            int max = Math.max(x, y);
            int a = 0;
            
            for (int i = min; i <= max; i++) {
                int temp = getSequenceLength(i, sequenceLengths);
                if (temp > a)
                    a = temp;
            }
            
            System.out.println(x + " " + y + " " + a);
        }
        in.close();
    }
    
    private static int getSequenceLength(int n, HashMap<Integer, Integer> sequenceLengths) {
        if (sequenceLengths.containsKey(n))
            return sequenceLengths.get(n);
        
        int length;
        if (n == 1)
            length = 1;
        else if (n % 2 == 0)
            length = 1 + getSequenceLength(n / 2, sequenceLengths);
        else
            length = 1 + getSequenceLength(n * 3 + 1, sequenceLengths);
        
        sequenceLengths.put(n, length);
        return length;
    }
}
