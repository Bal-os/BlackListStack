package kiev.prog;

public interface MyStack {
    boolean isEmpty();
    <T> void addHead(T e);
    <T> T getHead();
    <T> T removeHead();
    void deleteHead();
    void clear();
}
