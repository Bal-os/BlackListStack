package kiev.prog;

public interface MyQuery {
    boolean isEmpty();
    <T> void add(T e);
    <T> T getHead();
    <T> T removeHead();
    void clear();
}
