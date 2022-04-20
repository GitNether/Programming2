package tl.prog2.exercises.set04;

public class TrainTest {
    public static void main(String[] args) {
        Car temp;
        Locomotive big_chief = new Locomotive(23, 5311); // "Big Chief"
        Train santa_fe = new Train(big_chief); // "Santa Fe"
        santa_fe.add(new Car(12, 50));
        santa_fe.add(new Car(15, 75));
        santa_fe.add(new Car(20, 100));
        System.out.println("Santa Fe:\n" + santa_fe.toString());
        System.out.println("Cars:");
        temp = big_chief.getFirst();
        for(int i=1; i<=santa_fe.countCars(); i++){
            System.out.println("#" + i + ": Length: " + temp.getLength() + " Passengers: " + temp.getPassengers());
            temp = temp.getNext();
        }
        System.out.println();

        Locomotive steel_horse = new Locomotive(21, 5409); // "Steel Horse"
        Train rio_grande_express = new Train(steel_horse); // "Rio Grande Express"
        rio_grande_express.add(new Car(13, 60));
        rio_grande_express.add(new Car(18, 80));
        System.out.println("Rio Grande Express:\n" + rio_grande_express.toString());
        System.out.println("Cars:");
        temp = steel_horse.getFirst();
        for(int i=1; i<=rio_grande_express.countCars(); i++){
            System.out.println("#" + i + ": Length: " + temp.getLength() + " Passengers: " + temp.getPassengers());
            temp = temp.getNext();
        }
        System.out.println();

        rio_grande_express.relink(santa_fe);
        System.out.println("Relinked Rio Grande Express:\n" + rio_grande_express.toString());
        System.out.println("Cars:");
        temp = steel_horse.getFirst();
        for(int i=1; i<=rio_grande_express.countCars(); i++){
            System.out.println("#" + i + ": Length: " + temp.getLength() + " Passengers: " + temp.getPassengers());
            temp = temp.getNext();
        }
        System.out.println();

        rio_grande_express.revert();
        System.out.println("Reverted Rio Grande Express:\n" + rio_grande_express.toString());
        System.out.println("Cars:");
        temp = steel_horse.getFirst();
        for(int i=1; i<=rio_grande_express.countCars(); i++){
            System.out.println("#" + i + ": Length: " + temp.getLength() + " Passengers: " + temp.getPassengers());
            temp = temp.getNext();
        }
    }
}
