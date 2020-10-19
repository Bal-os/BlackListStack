package kiev.prog;

import java.lang.invoke.TypeDescriptor;
import java.util.*;

public class BlackList {
    private static final Map<Class<?>, Class<?>> TYPE_MAP = new HashMap<Class<?>, Class<?>>(18);
    static {
        TYPE_MAP.put(Integer.class, int.class);
        TYPE_MAP.put(Byte.class, byte.class);
        TYPE_MAP.put(Character.class, char.class);
        TYPE_MAP.put(Boolean.class, boolean.class);
        TYPE_MAP.put(Double.class, double.class);
        TYPE_MAP.put(Float.class, float.class);
        TYPE_MAP.put(Long.class, long.class);
        TYPE_MAP.put(Short.class, short.class);
        TYPE_MAP.put(Void.class, void.class);
    }
    static {
        TYPE_MAP.put(int.class, Integer.class);
        TYPE_MAP.put(byte.class, Byte.class);
        TYPE_MAP.put(char.class, Character.class);
        TYPE_MAP.put(boolean.class, Boolean.class);
        TYPE_MAP.put(double.class, Double.class);
        TYPE_MAP.put(float.class, Float.class);
        TYPE_MAP.put(long.class, Long.class);
        TYPE_MAP.put(short.class, Short.class);
        TYPE_MAP.put(void.class, Void.class);
    }
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
        if(currClass != null){
            if(TYPE_MAP.containsKey(currClass)) set.add(TYPE_MAP.get(currClass));
            set.add(currClass);
        }
    }
    public void add(Class ... arrayOfClasses) {
        if(arrayOfClasses != null){
            for (Class i: arrayOfClasses) {
                this.add(i);
            }
        }
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
            this.remove(currClass);
        }
    }
    public void remove(Class currClass){
        if(currClass != null) {
            if(TYPE_MAP.containsKey(currClass)) set.remove(TYPE_MAP.get(currClass));
            set.remove(currClass);
        }
    }
    public void remove(Class ... arrayOfClasses){
        if(arrayOfClasses != null){
            for (Class i: arrayOfClasses) {
                this.remove(i);
            }
        }
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
