public class ShortestWithOneSwap {

    public static void main(String[] args) {
        String shortest = ShortestWithOneSwap.find_smallest_number("210");
        System.out.print(shortest);
    }

    public static String find_smallest_number(String input) {
        char[] number = input.toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < number.length; i++) {
            last[number[i] - '0'] = i;
        }

        outer:
        for (int i = 0; i < number.length; i++) {
            for (int j = 1; j < number[i] - '0'; j++) {
                if (last[j] > 0 && last[j] > i) {
                    char temp;
                    temp = number[i];
                    number[i] = number[last[j]];
                    number[last[j]] = temp;
                    break outer;
                }
            }
        }
        return new String(number);
    }

}
