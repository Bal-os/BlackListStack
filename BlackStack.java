package kiev.prog;

public interface BlackStack extends MyStack {
    <T> void addClassToBlackList(T e);
    void addBlackList(BlackList other);
    <T> boolean addHeadB(T e);
    void clearBlackList();
}
