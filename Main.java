package kiev.prog;


import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        MyLinkedList List = new MyLinkedList();
        List.add("hui1");
        List.addHead(123);
        for(int i = 0; i < List.size(); i++){
            System.out.println(List.get(i).toString());
        }
    }
}
