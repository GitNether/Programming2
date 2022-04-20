package tl.prog2.exercises.set04;

public class Locomotive {
    private final int length;
    private final int type;
    private Car first = null;

    public Locomotive(int length, int type){
        this.length = length;
        this.type = type;
    }

    public int countCars(){
        if(first==null){
            return 0;
        }else{
            return first.countCars();
        }
    }

    public void add(Car car){
        if(first==null){
            setFirst(car);
        }else{
            first.add(car);
        }
    }

    public int sumLength(){
        if(first==null){
            return length;
        }else{
            return length + first.sumLength();
        }
    }

    public int sumPassengers(){
        if(first==null){
            return 0;
        }else{
            return first.sumPassengers();
        }
    }

    public Car getFirst(){
        return first;
    }

    public void setFirst(Car car){
        first = car;
    }

    public int getLength(){
        return length;
    }

    public int getType(){
        return type;
    }
}
