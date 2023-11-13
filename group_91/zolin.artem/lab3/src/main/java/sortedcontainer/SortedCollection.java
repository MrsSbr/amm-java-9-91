package sortedcontainer;

import java.util.Collection;
import java.util.Iterator;

public interface SortedCollection<T> {

    void add(T item);

    boolean isEmpty();

    Iterator<T> iterator();

    Collection<T> getUnmodifiableView();

}
