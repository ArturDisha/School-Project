public class BitInSn {
    public static char getBit(int i, int n) {
        String Sn = generateSn(n);
        return Sn.charAt(i - 1);
    }
    public static String generateSn(int n) {
        if (n == 1) {
            return "1";
        } else {
            String prev = generateSn(n - 1);
            String invertedReverse = invert(reverse(prev));
            return prev + "0" + invertedReverse;
        }
    }
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    public static String invert(String str) {
        StringBuilder inverted = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '0') {
                inverted.append('1');
            } else {
                inverted.append('0');
            }
        }
        return inverted.toString();
    }
    public static void main(String[] args) {
        int i = 1;
        int n = 3;
        char ithBit = getBit(i, n);
        System.out.println("The " + i + "th bit in S" + n + " is: " + ithBit);
    }
}
