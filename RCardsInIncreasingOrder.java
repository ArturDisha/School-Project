import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck); 
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < deck.length; i++) {
            deque.add(i);
        }
        int[] result = new int[deck.length];
        for (int card : deck) {
            result[deque.pollFirst()] = card; 
            if (!deque.isEmpty()) {
                deque.add(deque.pollFirst()); 
            }
        }
        return result;
    }
    public static void main(String[] args) {
        RCardsInIncreasingOrder solution = new RCardsInIncreasingOrder();
        int[] deck1 = {17, 13, 11, 2, 3, 5, 7};
        int[] result1 = solution.deckRevealedIncreasing(deck1);
        System.out.println("Input: " + Arrays.toString(deck1));
        System.out.println("Output: " + Arrays.toString(result1)); 

       
    }
}
