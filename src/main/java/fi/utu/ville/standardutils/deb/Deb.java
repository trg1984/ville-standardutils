package fi.utu.ville.standardutils.deb;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Stream;
// TODO: after refreshing, a null reference may turn out to be a classState, baseType,

/**
 * A temporary testing class
 */
public class Deb {

    public static void main(String[] args) {
        TestA a = new TestA();
//        parse(a);
        ObjectStateFactory f = new ObjectStateFactory();
        AbstractObjectState s =  f.createRoot(a);
        s.readState(3);
        System.out.println(s.toStringRecursive());
        s.readState();
    }
}

class ObjectStateDiff extends AbstractStateTree<ObjectStateDiff, AbstractObjectState> {

    enum ChangeType {
        NO_CHANGE,
        CHANGED,
        NEW,
        REMOVED
    }
    private ArrayList<ObjectStateDiff> children = new ArrayList<>();

    public ObjectStateDiff(ObjectStateDiff parent, AbstractObjectState value) {
        super(value, parent);
    }

    @Override
    public Stream<ObjectStateDiff> children() {
        return children.stream();
    }

    public static ObjectStateDiff create(ObjectStateDiff old, AbstractObjectState newState) {
        ChangeType type = ChangeType.NO_CHANGE;
        if(old == null) {
            type = ChangeType.NEW;
        }
        else if(old.getValue().equals(newState)) {

        }
        return null;
    }
}

/**
 * A temporary testing class
 */
class TestA {
      private static int i = 42;
      private int a = 84;
//    private TestA b;
//    private TestA parent;
//    private TestA[] c;
    private ArrayList<TestA> arr;
//    private ArrayList<Integer> arr2;
    public TestA() {
        this(null);
    }
    public TestA(TestA parent) {
//        a = i;
//        i++;
//        this.parent = parent;
        Random rand = new Random();
        if(parent == null) {
//            b = new TestA(this);
            TestA b = new TestA(this);
//            c = new TestA[]{new TestA(b)};
            arr = new ArrayList<>();
            arr.add(b);
//            arr2 = new ArrayList<>();
//            arr2.add(420);
        }
    }
//    public void inc() { a = a +1; }

}