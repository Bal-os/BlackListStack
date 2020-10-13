package kiev.prog;

public interface MyQuery {
    boolean isEmpty();
    <T> T add();
    <T> T getHead();
    <T> T removeHead();
    void clear();
}
