public class RecursiveProduct {
    public static int product(int m, int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return m;
        } else if (n == -1) {
            return -m;
        }
        if (n > 0) {
            return m + product(m, n - 1);
        } else {
            return -m + product(m, n + 1);
        }
    }
    public static void main(String[] args) {
        int m = 24;
        int n = 45;
        System.out.println("Product of " + m + " and " + n + " is: " + product(m, n));
    }
}
