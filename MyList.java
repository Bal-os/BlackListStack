package kiev.prog;

public interface MyList {
    int size();
    boolean isEmpty();
    <T> void add(T e); // add element e to the end of List
    <T> T get(int index);
    <T> T remove(int index);
    void delete(int index);
    public <T> int indexOf(T e);
    public <T> boolean contains(T e);
    void clear();
}
