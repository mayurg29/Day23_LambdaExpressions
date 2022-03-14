import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NumberPlayList {
    public static void main(String[] args) {
        
	// Creating sample collection
        List<Integer> myNumberList = new ArrayList<>();
        for (int i = 0; i < 7; i++) myNumberList.add(i);

        // Method 1: Traversing using Iterator
        Iterator<Integer> it = myNumberList.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println("Mth1: Iterator value::" + i);
        }

        // Method 2: Traversing with Explicit Consumer interface implementation
        class MyConsumer implements Consumer<Integer> {
            public void accept(Integer t) {
                System.out.println("Mth2: Consumer impl value::" + t);
            }
        }
        MyConsumer action = new MyConsumer();
        myNumberList.forEach(action);

        // Method 3: Traversing with Anonymous Consumer interface implementation
        myNumberList.forEach(new Consumer<Integer>() {
            public void accept(Integer t) {
                System.out.println("Mth3: forEach anonymous class value::" + t);
            }
        });

        // Method 4: Explicit Lambda Function
        Consumer<Integer> myListAction = n -> {
            System.out.println("Mth4: forEach Lambda expl val::" + n);
        };
        myNumberList.forEach(myListAction);

        // Method 5: Implicit Lambda Function
        myNumberList.forEach( n -> {
            System.out.println("Mth5: forEach Lambda impl val::" + n);
        });

        // Method 6: Implicit Lambda Function to print double value
        Function<Integer, Double> toDoubleFunction = Integer::doubleValue;
        myNumberList.forEach( n -> {
            System.out.println("Mth6: forEach Lambda double val::" + toDoubleFunction.apply(n));
        });

        // Method 7: Implicit Lambda Function to check even
        Predicate<Integer> isEvenFunction = n -> n > 0 && n % 2 == 0;
        myNumberList.forEach( n -> {
            System.out.println("Mth7: forEach value: " + n +
                               " check for even: " + isEvenFunction.test(n));
        });
    }
}
