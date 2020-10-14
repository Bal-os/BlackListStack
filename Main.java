package kiev.prog;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Main {
    public static void main(String[] args){
        List stack = new MyLinkedListAdapter();
        stack.add("hui1");
        stack.add("hui2");
        stack.add("hui3");
        stack.add("hui4");
        for(var i: stack){
            System.out.println(i + " " + stack.indexOf(i));
        }
        System.out.println();
        System.out.println(stack.remove("hui1"));
        System.out.println();
        int j = 0;
        for(var i: stack){
            System.out.println(i + " " + stack.indexOf(i));
            System.out.println(stack.get(j));
            j++;
        }
    }
}
