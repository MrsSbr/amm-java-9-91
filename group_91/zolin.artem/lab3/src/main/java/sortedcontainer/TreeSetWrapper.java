package sortedcontainer;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetWrapper<T> implements SortedCollection<T> {

    private final TreeSet<T> data;

    public TreeSetWrapper(Comparator<T> comparator) {
        data = new TreeSet<>(comparator);
    }

    @Override
    public void add(T item) {
        data.add(item);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }

    @Override
    public Collection<T> getUnmodifiableView() {
        return Collections.unmodifiableSet(data);
    }

}
