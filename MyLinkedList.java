package kiev.prog;


public class MyLinkedList implements MyList, MyStack {
    private Node head = null;
    private Node last;
    private int size = 0;

    public MyLinkedList() {
    }

    public <T> MyLinkedList(T ... a) {
        switch (a.length) {
            case 0: break;
            case 1: head = last = new Node(a[0], null); break;
            case 2: last = new Node(a[1], null);
                    head = new Node(a[0], last);
                    break;
            default:
                    last = new Node(a[a.length - 1], null);
                    head = last;
                    for(int i = a.length - 2; i >= 0; i--){
                        add(a[i]);
                    }
                    break;
        }
    }

    private void checkIndex(int index) throws ArrayIndexOutOfBoundsException{
        if (index >= size) {throw new ArrayIndexOutOfBoundsException("MyList is smaller");}
    }

    private Node findPrev(int index) throws ArrayIndexOutOfBoundsException{
        checkIndex(index);
        Node prevNode = head;
        for(int i = 1; i < index; i++)
        {
            prevNode = prevNode.next;
        }
        return prevNode;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public <T> void add(T e) {
        if (isEmpty()){
            addHead(e);
        } else {
            last.next = new Node(e, null);
            last = last.next;
            size++;
        }
    }

    public <T> void set(T e) {
        set(size - 1, e);
    }

    public <T> T get(){
        return (T) last.data;
    }

    public <T> T remove(){
        return remove(size - 1);
    }

    public void delete(){
        delete(size - 1);
    }

    @Override
    public <T> void addHead(T e) {
        head = new Node(e, head);
        if(isEmpty()) {last = head;}
        size++;
    }

    public <T> void setHead(T e) {
        head = new Node(e, head.next);
        if(isEps()){
            last = head;
            if(isEmpty()) size++;
        }
    }

    @Override
    public <T> T getHead(){
        return (T) head.data;
    }

    @Override
    public <T> T removeHead(){
        T result = (T) head.data;
        deleteHead();
        return result;
    }

    @Override
    public void deleteHead() {
        if(isEps()){
            clear();
        }
        else {
            head = head.next;
            size--;
        }
    }

    public <T> void add(int index, T e) throws ArrayIndexOutOfBoundsException{
        if (index == 0) {addHead(e);}
        Node prevNode = findPrev(index);
        prevNode.next = new Node(e, prevNode.next);
        size++;
    }

    public <T> void set(int index, T e) throws ArrayIndexOutOfBoundsException{
        if (index == 0) {setHead(e);}
        Node prevNode = findPrev(index);
        prevNode.next = new Node(e, prevNode.next.next);
    }

    @Override
    public <T> T get(int index) throws ArrayIndexOutOfBoundsException{
        if (index == 0) {return getHead();}
        Node thisNode = findPrev(index).next;
        return (T) thisNode.data;
    }

    @Override
    public <T> T remove(int index) throws ArrayIndexOutOfBoundsException{
        T result = get(index);
        delete(index);
        return result;
    }

    @Override
    public void delete(int index) throws ArrayIndexOutOfBoundsException{
        if (index == 0) {deleteHead();}
        Node prevNode = findPrev(index);
        prevNode.next = prevNode.next.next;
        size--;
    }

    public <T> T remove(T e) throws ArrayIndexOutOfBoundsException{
        return remove(indexOf(e));
    }

    public <T> void delete(T e) throws ArrayIndexOutOfBoundsException{
        delete(indexOf(e));
    }

    @Override
    public <T> int indexOf(T e){
        Node thisNode = head;
        for (int i = 0; i < size; i++) {
            if(thisNode.data.equals(e)) {return i;}
            thisNode = thisNode.next;
        }
        return size;
    }

    @Override
    public <T> boolean contains(T e){
        return indexOf(e) != size;
    }

    @Override
    public void clear() {
        head = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    private boolean isEps() {
        return size <= 1;
    }

    protected static class Node<T>{
        T data;
        Node next;

        Node(){}
        Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }
}
