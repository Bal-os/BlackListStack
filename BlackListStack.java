package kiev.prog;

public class BlackListStack extends MyLinkedList implements BlackStack{
    BlackList bl;
    /**
     * Constructs a new, empty Stack
     */
    BlackListStack(){
        bl = new BlackList();
    }

    /**
     * Constructs a new Stack, based on existed black list
     *
     * @param bl object which will be copied to this Stack
     */
    BlackListStack(BlackList bl){
        this.bl = bl;
    }

    /**
     * Add the class to BlackList of classes
     *
     * @param e object of class add for
     */
    public <T> void addClassToBlackList(T e){
        this.bl.add(e);
    }

    /**
     * Add the BlackList of classes to this Stack BlackList
     *
     * @param other object of BlackList add for
     */
    public void addBlackList(BlackList other){
        this.bl.add(other);
    }

    /**
     * Make BlackList of this Stack
     */
    public void clearBlackList(){
        bl = new BlackList();
    }

    /**
     * Add the element to the head of the Stack if class of {@code e}
     * not contains in BlackList of this Stack
     *
     * @param e element to add for
     * @return  {@code true} if and only if head is added
     *          {@code false} otherwise.
     */
    public <T> boolean addHeadB(T e){
        boolean result = !bl.contains(e);
        if(result) {super.addHead(e);}
        return result;
    }

    /**
     * Add the element to the head of the Stack if class of {@code e}
     * not contains in BlackList of classes
     *
     * @param e element to add for
     * @throws ClassCastException if class in black list
     */
    @Override
    public <T> void addHead(T e) throws ClassCastException{
        if(!addHeadB(e)) throw new ClassCastException("class in black list");
    }

    /**
     * Returns a string representation of this Stack, containing
     * the String representation of each element and BlackList
     * of this Stack
     */
    @Override
    public String toString() {
        String result = this.getClass().getName() + ":{\n";
        Node thisNode = super.head;
        for (int i = 0; i < super.size(); i++){
            result += "\t" + thisNode.toString() + "\n";
            thisNode = thisNode.next;
        }
        result += "\n\t" + this.bl.toString() + "}";
        return result;
    }
}
