package tl.prog2.exercises.set02.sequences;

public class SequenceTest {

    public static void main(String[] args) {
        //println(new Naturals());
        //println(new Range(7, 15));
        //println(new Evens(new Range(7,15)));
        //println(new ZapMultiples(new Range(7, 15), 3));

        //println(new ZapMultiples((new Evens(new Naturals())), 2)); // -> problematisch, da alle Geraden Zahlen ein Vielfaches von 2 sind

        println(new PrimeNumbers(1000));

    }

    private static void println(Sequence s){
        int counter = 0;
        while(s.hasNext()){
            if(counter%35==0){
                System.out.println();
            }
            System.out.print(s.nextElement() + " ");
            counter++;
        }
    }

}
