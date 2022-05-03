package tl.prog2.exercises.set07;

public class MyDeque<T> {

    T[] array;
    int startindex = 0, endindex = 0, capacity;

    public MyDeque(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    boolean isEmpty() {
        boolean ret = true;
        for(T elem : array) {
            if(elem!=null) { ret = false; }
        }
        return ret;
    }

    boolean isFull() {
        boolean ret = true;
        for(T elem : array) {
            if(elem==null) { ret = false; }
        }
        return ret;
    }

    int size() {
        int size = 0;
        for(T elem : array) {
            if(elem!=null) { size++; }
        }
        return size;
    }

    int capacity() {
        return capacity;
    }

    T get (int i) {
        return array[(startindex+i)%capacity];
    }

    void addFirst(T elem) {
        int index = startindex-1;
        if(index<0) { index += capacity; }
        if(!(isFull())) {
            array[index] = elem;
            startindex = index;
        } else {
            throw new RuntimeException("Cannot override data!");
        }
    }

    T getFirst() {
        return array[startindex];
    }

    T removeFirst() {
        T temp = array[startindex];
        array[startindex] = null;
        if(isEmpty()) { startindex = 0; endindex = 0; }
        else { startindex = (startindex+1)%capacity; }
        return temp;
    }

    void addLast(T elem) {
        int index = (endindex+1)%capacity;
        if(!(isFull())) {
            array[endindex] = elem;
            endindex = index;
        } else {
            throw new RuntimeException("Cannot override data!");
        }
    }

    T getLast() {
        return array[endindex];
    }

    T removeLast() {
        T temp = array[endindex];
        array[endindex] = null;
        if(isEmpty()) { startindex = 0; endindex = 0; }
        else { endindex = startindex-1; if(endindex<0) { endindex += capacity; } }
        return temp;
    }

    public String toString() {
        String s = "Capacity: " + capacity + " | Size: " + size() + "\n";
        if(isEmpty()){
            s += "Array empty.";
        } else {
            System.out.println("Elements:");
            for(int i=0; i<capacity; i++) {
                System.out.println(i + " " + array[i].toString());
            }
        }
        return s;
    }
}
