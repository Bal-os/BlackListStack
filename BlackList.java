package kiev.prog;

import java.lang.invoke.TypeDescriptor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BlackList {
    private Set<Class> set = new HashSet<Class>();
    public BlackList(){
    }
    public BlackList(Class ... arrayOfClasses){
        if(arrayOfClasses != null) set.addAll(Arrays.asList(arrayOfClasses));
    }
    public <T> void add(T obj){
        if(obj != null) {
            Class currClass = obj.getClass();
            this.add(currClass);
        }
    }
    public void add(Class currClass){
        if(currClass != null) set.add(currClass);
    }
    public void add(Class ... arrayOfClasses){
        if(arrayOfClasses != null) set.addAll(Arrays.asList(arrayOfClasses));
    }
    public void add(BlackList other){
        if(other != null &&!other.equals(this))
            for(Class currClass: other.set){
                this.add(currClass);
            }
    }
    public boolean contains(Class currClass){
        if(currClass != null) return set.contains(currClass);
        return false;
    }
    public <T> boolean contains(T obj){
        if(obj != null) {
            Class currClass = obj.getClass();
            return set.contains(currClass);
        }
        return false;
    }
    public <T> void remove(T obj){
        if(obj != null){
            Class currClass = obj.getClass();
            set.remove(currClass);
        }
    }
    public void remove(Class currClass){
        if(currClass != null) set.remove(currClass);
    }
    public void remove(Class ... arrayOfClasses){
        if(arrayOfClasses != null) set.removeAll(Arrays.asList(arrayOfClasses));
    }

    @Override
    public int hashCode() {
        return set.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)) return true;
        else if(obj==null) return false;
        else if(this.getClass()!=obj.getClass()) return false;
        BlackList blackList = (BlackList) obj;
        return blackList.set.equals(this.set);
    }

    @Override
    public String toString() {
        String result = this.getClass().getSimpleName() + ": {\n";
        for(Class currClass: set){

            result += "\t" + currClass.getSimpleName() + "\n";
        }
        result += "}";
        return result;
    }
}
