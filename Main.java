package kiev.prog;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args){
        Integer i = 5;
        Class c = int.class;
        Class cc = c.getClass();
        BlackStack stack = new BlackListStack();
        BlackList blackList = new BlackList(int.class, void.class, MyStack.class, Class.class);
        stack.addBlackList(blackList);
        BlackList blackList1 = new BlackList();
        blackList1.add((Object)blackList);
        //stack.addBlackList(blackList1);
        Consumer<Integer> f = x -> {
            x += i;
        };
        stack.addHead(i);
        stack.addHead(f);
        stack.addHead(5.);
        boolean b = stack.addHeadB((Object)blackList);
        stack.addHead(b);
        stack.addHead("");
        System.out.println(stack.toString());
    }
}
