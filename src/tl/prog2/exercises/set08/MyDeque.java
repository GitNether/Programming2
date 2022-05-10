package tl.prog2.exercises.set08;

import java.util.Iterator;

public class MyDeque<T extends Comparable<T>> {

    T[] array;
    int startindex = 0, endindex = 0, capacity;

    public MyDeque(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        boolean ret = true;
        for(T elem : array) {
            if(elem!=null) { ret = false; }
        }
        return ret;
    }

    public boolean isFull() {
        boolean ret = true;
        for(T elem : array) {
            if(elem==null) { ret = false; }
        }
        return ret;
    }

    public int size() {
        int size = 0;
        for(T elem : array) {
            if(elem!=null) { size++; }
        }
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public T get (int i) {
        return array[(startindex+i)%capacity];
    }

    public void addFirst(T elem) {
        int index = startindex-1;
        if(isEmpty()) { index = 0; }
        if(index<0) { index += capacity; }
        if(!(isFull())) {
            array[index] = elem;
            startindex = index;
            if(endindex==index) { endindex = startindex; }
        } else {
            throw new RuntimeException("Cannot override data!");
        }
    }

    public T getFirst() {
        return array[startindex];
    }

    public T removeFirst() {
        T temp = array[startindex];
        array[startindex] = null;
        if(isEmpty()) { startindex = 0; endindex = 0; }
        else { startindex = (startindex+1)%capacity; }
        return temp;
    }

    public void addLast(T elem) {
        int index = (endindex+1)%capacity;
        if(isEmpty()) { index = 0; startindex = 0; endindex = 0; }
        if(!(isFull())) {
            array[index] = elem;
            endindex = index;
            if(startindex == index) { startindex = endindex; }
        } else {
            throw new RuntimeException("Cannot override data!");
        }
    }

    public T getLast() {
        return array[endindex];
    }

    public T removeLast() {
        T temp = array[endindex];
        array[endindex] = null;
        if(isEmpty()) { startindex = 0; endindex = 0; }
        else { endindex = (endindex-1)%capacity; if(endindex<0) { endindex += capacity; } }
        return temp;
    }

    public String toString() {
        /*String s = "Capacity: " + capacity + " | Size: " + size() + "\n";
        if(isEmpty()){
            s = s + "Array empty.";
        } else {
            s = s + "Elements:\n";
            for(int i=0; i<capacity; i++) {
                s = s + i + ": " + array[i] + "\n";
            }
        }
        return s;*/

        /*
        String s = "[ ";
        for(T elem : array) {       // <= Ausgabe wie das Array grad aussieht
            s += elem + " ";
        }
        return s+="]";
        */

        String s = "[ ";
        for(int i=capacity; i<capacity+size(); i++){    // <= Ausgabe wie der Ringbuffer aussieht
            s += get(i%capacity) + " ";
        }
        return s + "]";
    }

    class Iterator<T> {
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private int index = 0;

                public boolean hasNext() {
                return MyDeque.this.get(index) != null;
            }

                public T next() {
                return (T) MyDeque.this.get((index++) % MyDeque.this.capacity());
            }
            };
        }
    }
}