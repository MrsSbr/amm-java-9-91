import java.util.LinkedList;
import java.util.ListIterator;

public class LastRemainingNumber {
    public static int taskEliminationGame(int n) {

        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            numbers.add(i + 1);
        }

        boolean leftToRight = true;
        boolean needsRemoval = true;
        ListIterator<Integer> iter = numbers.listIterator();

        while (numbers.size() > 1) {

            if (leftToRight) {

                while (iter.hasNext()) {
                    iter.next();
                    if (needsRemoval) {
                        iter.remove();
                        needsRemoval = false;
                    } else {
                        needsRemoval = true;
                    }
                }

                leftToRight = false;
                iter = numbers.listIterator(numbers.size());

            }

            else {

                while (iter.hasPrevious()) {
                    iter.previous();
                    if (needsRemoval) {
                        iter.remove();
                        needsRemoval = false;
                    } else {
                        needsRemoval = true;
                    }
                }

                leftToRight = true;
                iter = numbers.listIterator();

            }

            needsRemoval = true;

        }

        return numbers.listIterator().next();
    }
}
