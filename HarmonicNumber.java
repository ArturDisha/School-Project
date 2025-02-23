public class HarmonicNumber {
    public static double harmonicNumber(int n) {
        if (n == 1) {
            return 1;
        } else {
            return 1 + 1.0 / (n * harmonicNumber(n - 1));
        }
    }

    public static void main(String[] args) {
        int n = 124;
        double hn = harmonicNumber(n);
        System.out.println("The " + n + "th Harmonic number is : " + hn);
    }
}
