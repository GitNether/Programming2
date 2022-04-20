    package tl.prog2.exercises.set04;

    import java.util.*;

    public class ListTest {

        public static void main(String[] args) {
            ArrayList al = new ArrayList();
            LinkedList ll = new LinkedList();
            long start, time;
            Iterator<Integer> iterator;

            Scanner scanner = new Scanner(System.in);
            System.out.print("Input number of elements: ");
            int elements = scanner.nextInt();
            System.out.println();

            System.out.println("Add " + elements + " elements:");

            start = System.nanoTime();
            for(int i=0; i<elements; i++){
                al.add(i);
            }
            time = System.nanoTime() - start;
            System.out.println("ArrayList: " + n2m(time) + " ms");

            start = System.nanoTime();
            for(int i=0; i<elements; i++){
                ll.add(i);
            }
            time = System.nanoTime() - start;
            System.out.println("LinkedList: " + n2m(time) + " ms");
            System.out.println();

            al.clear();
            ll.clear();

            System.out.println("Insert " + elements + " elements at the beginning of the list:");

            start = System.nanoTime();
            for(int i=0; i<elements; i++){
                al.add(0, i);
            }
            time = System.nanoTime() - start;
            System.out.println("ArrayList: " + n2m(time) + " ms");

            start = System.nanoTime();
            for(int i=0; i<elements; i++){
                ll.add(0, i);
            }
            time = System.nanoTime() - start;
            System.out.println("LinkedList: " + n2m(time) + " ms");
            System.out.println();

            al.clear();
            ll.clear();
            for(int i=0; i<elements; i++){
                al.add(i);
                ll.add(i);
            }

            System.out.println("Accessing all " + elements + " elements using index:");

            start = System.nanoTime();
            for(int i=0; i<al.size(); i++){
                al.get(i);
            }
            time = System.nanoTime() - start;
            System.out.println("ArrayList: " + n2m(time) + " ms");

            start = System.nanoTime();
            for(int i=0; i<ll.size(); i++){
                ll.get(i);
            }
            time = System.nanoTime() - start;
            System.out.println("LinkedList: " + n2m(time) + " ms");
            System.out.println();

            System.out.println("Accessing all " + elements + " elements using iterator:");

            iterator = al.iterator();
            start = System.nanoTime();
            while(iterator.hasNext()){
                iterator.next();
            }
            time = System.nanoTime() - start;
            System.out.println("ArrayList: " + n2m(time) + " ms");

            iterator = ll.iterator();
            start = System.nanoTime();
            while(iterator.hasNext()){
                iterator.next();
            }
            time = System.nanoTime() - start;
            System.out.println("LinkedList: " + n2m(time) + " ms");
        }

        public static double n2m(long nano){
            return ((double)nano)/1000000;
        }
    }