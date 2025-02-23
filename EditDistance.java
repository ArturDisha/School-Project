import java.util.HashMap;

public class EditDistance {
    public static int minDistance(String s, String t) {
        HashMap<String, Integer> memo = new HashMap<>();
        return minDistanceRecursive(s, t, s.length() - 1, t.length() - 1, memo);
    }

    private static int minDistanceRecursive(String s, String t, int i, int j, HashMap<String, Integer> memo) {
        if (i < 0) {
            return j + 1; 
        }
        if (j < 0) {
            return i + 1; 
        }

        String key = i + "-" + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

      
        if (s.charAt(i) == t.charAt(j)) {
            return minDistanceRecursive(s, t, i - 1, j - 1, memo);
        }

        
        int substitute = minDistanceRecursive(s, t, i - 1, j - 1, memo);
        int insert = minDistanceRecursive(s, t, i, j - 1, memo);
        int delete = minDistanceRecursive(s, t, i - 1, j, memo);

    
        int minDistance = 1 + Math.min(substitute, Math.min(insert, delete));
        memo.put(key, minDistance);

        return minDistance;
    }

    public static void main(String[] args) {
        String s = "intention";
        String t = "execution";
        System.out.println("The minimum edit distance between " + s + " " + t +  " " + "is" + " " +  minDistance(s, t));
    }
}
