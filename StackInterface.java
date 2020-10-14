package kiev.prog;

public interface StackInterface <E>{
    public E push(E item);


    public E pop();


    public E peek();


    public boolean empty();


    public int search(Object o);
}
