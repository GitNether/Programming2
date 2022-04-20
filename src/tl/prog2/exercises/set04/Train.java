package tl.prog2.exercises.set04;

public class Train {
    private Locomotive locomotive;

    public Train(Locomotive locomotive){
        this.locomotive = locomotive;
    }

    public boolean hasCars(){
        return !(locomotive.getFirst()==null);
    }

    public void add(Car car, int index){
        if(index==0){
            add(car);
        }else{
            locomotive.getFirst().add(car, index, 0);
        }
    }

    public void add(Car car){
        locomotive.add(car);
    }

    public void relink(Train train){
        while(train.hasCars()){
            Car temp = train.removeFirst();
            add(temp);
        }
    }

    public void revert(){
            Car temp = removeFirst();
            if(hasCars()){ revert(); }
            add(temp);
    }

    public String toString(){
        return "Type: " + locomotive.getType() + " Cars: " + countCars() + " Length: " + getLength() + " Passengers: " + getPassengers();
    }

    public int countCars(){
        return locomotive.countCars();
    }

    public Car removeFirst(){
        Car first = locomotive.getFirst();
        locomotive.setFirst(first.getNext());
        first.setNext(null);
        return first;
    }

    public int getPassengers(){
        return locomotive.sumPassengers();
    }

    public int getLength(){
        return locomotive.sumLength();
    }
}
