package kiev.prog;

import java.util.*;

public class MyLinkedListAdapter<E> implements Queue<E>, List<E>, StackInterface<E> {
    private MyLinkedList list = new MyLinkedList();

    public MyLinkedListAdapter() {

    }

    @Override
    public E push(E item) {
        list.addHead(item);
        return item;
    }

    @Override
    public synchronized E pop() {
        return list.removeHead();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[list.size()];
        for(int i = 0; i < list.size(); i++){
            array[i] = list.get(i);
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        for(int i = 0; i < list.size(); i++){
            a[i] = list.get(i);
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        list.add(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int i = list.indexOf(o);
        list.delete(o);
        return (list.indexOf(o) != i);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (var i: c){
            if(list.indexOf(i) == list.size()) {return false;}
        }
        return true;
    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (var i: c){
            list.add(i);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (var i: c){
            if(list.indexOf(i) != size()) list.delete(i);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        MyLinkedList newList = new MyLinkedList();
        for (var i: c){
            if(list.indexOf(i) != size()) newList.add(i);
        }
        list = newList;
        return true;
    }

    @Override
    public void clear() {list.clear();}

    @Override
    public boolean offer(E e) {
        list.add(e);
        return true;
    }
    @Override
    public E remove() {
        if(list.isEmpty()) throw new NoSuchElementException("stack is empty");
        return list.removeHead();
    }

    @Override
    public E poll() {
        return list.removeHead();
    }

    @Override
    public E element() {
        if(list.isEmpty()) throw new NoSuchElementException("stack is empty");
        return list.getHead();
    }

    @Override
    public synchronized E peek() {return list.getHead(); }

    @Override
    public boolean empty() {
        return list.isEmpty();
    }

    @Override
    public synchronized int search(Object o) {
        int i = list.indexOf(o);
        if (i < list.size()) {
            return i;
        }
        return -1;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        int i = index;
        for(var element: c){
            list.add(i, element);
            i++;
        }
        return true;
    }

    @Override
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public E set(int index, E element) throws IndexOutOfBoundsException{
        list.set(index, element);
        return element;
    }

    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException{
        list.add(index, element);
    }

    @Override
    public E remove(int index) {
        return list.remove(index);
    }

    private int index(int result){
        if(result == list.size()) return -1;
        return result;
    }

    @Override
    public int indexOf(Object o) {
        return index(list.indexOf(o));
    }

    @Override
    public int lastIndexOf(Object o) {
        return index(list.lastIndexOf(o));
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        if (toIndex > list.size())
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                    ") > toIndex(" + toIndex + ")");
        for(int i = toIndex; i < list.size(); i++)
        {
            list.delete(i);
        }
        int count = fromIndex - 1;
        while(count > 0){
            list.deleteHead();
            count--;
        }
        return (List<E>) list;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new MyLinkedListAdapterListIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > list.size())
            throw new IndexOutOfBoundsException("Index: "+index);
        return new MyLinkedListAdapterListIterator(index);
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListAdapterIterator();
    }

    private class MyLinkedListAdapterIterator implements Iterator<E> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such

        @Override
        public boolean hasNext() {
            return cursor != list.size();
        }

        @Override
        public E next() {
            int i = cursor;
            if (i >= list.size())
                throw new NoSuchElementException();
            cursor = i + 1;
            return list.get(lastRet = i);
        }

    }

    private class MyLinkedListAdapterListIterator extends MyLinkedListAdapterIterator
            implements ListIterator<E> {
        MyLinkedListAdapterListIterator(int index) {
            super();
            cursor = index;
        }

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public E previous() {
            int i = cursor - 1;
            if (i < 0)
                throw new NoSuchElementException();
            cursor = i;
            return list.get(lastRet = i);
        }

        @Override
        public void set(E e) {
            if (lastRet == -1)
                throw new IllegalStateException();
            list.set(lastRet, cursor);
        }

        @Override
        public void add(E e) {
            list.add(cursor, e);
            cursor++;
            lastRet = -1;
        }

        @Override
        public void remove() {
            if (lastRet == -1)
                throw new IllegalStateException();
            list.delete(lastRet);
            cursor = lastRet;
            lastRet = -1;
        }

    }

}
