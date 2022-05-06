package tl.prog2.exercises.set07;

public class MyDequeUtil {

    public static <T extends Comparable<T>> MyDeque<T> merge(MyDeque<T> d1, MyDeque<T> d2) {
        MyDeque<T> d = new MyDeque<T>(d1.capacity()+d2.capacity());
        for(int i = 0; i < d1.size(); i++) {
            d.addLast(d1.get((d1.startindex+i)%d1.capacity()));
        }
        for(int i = 0; i < d2.size(); i++) {
            d.addLast(d2.get((d2.startindex+i)%d2.capacity()));
        }
        return d;
    }

    public static <T extends Comparable<T>> MyDeque<T> selectLess(MyDeque<T> d, T compare) {
        MyDeque<T> deque = new MyDeque<T>(d.capacity());
        for(int i = 0; i < d.size(); i++) {
            if(d.get((d.startindex+i)% d.capacity()).compareTo(compare) < 0) { deque.addLast(d.get((d.startindex+i)% d.capacity())); }
        }
        return deque;
    }
}
