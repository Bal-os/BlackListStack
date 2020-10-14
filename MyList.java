package kiev.prog;

import java.util.Iterator;

public interface MyList{
    int size();
    boolean isEmpty();
    <T> void add(T e); // add element e to the end of List
    <T> T get(int index);
    <T> T remove(int index);
    void delete(int index);
    <T> int indexOf(T e);
    <T> int lastIndexOf(T e);
    <T> boolean contains(T e);
    void clear();
}
