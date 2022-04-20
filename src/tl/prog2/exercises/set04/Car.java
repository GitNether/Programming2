package tl.prog2.exercises.set04;

public class Car {
    private final int length;
    private final int passengers;
    private Car next = null;

    Car(int length, int passengers){
        this.length = length;
        this.passengers = passengers;
    }

    public void add(Car car, int index, int myIndex){
        if(index==++myIndex){
            Car temp = getNext();
            setNext(car);
            car.setNext(temp);
        }else{
            next.add(car, index, myIndex+1);
        }
    }

    public void add(Car car){
        if(next==null){
            setNext(car);
        }else{
            next.add(car);
        }
    }

    public int countCars(){
        if(next==null){
            return 1;
        }else{
            return 1 + next.countCars();
        }
    }

    public int sumLength(){
        if(next==null){
            return getLength();
        }else{
            return getLength() + next.sumLength();
        }
    }

    public int sumPassengers(){
        if(next==null){
            return getPassengers();
        }else{
            return getPassengers() + next.sumPassengers();
        }
    }

    public Car getNext(){
        return next;
    }

    public void setNext(Car car){
        next = car;
    }

    public int getLength(){
        return length;
    }

    public int getPassengers(){
        return passengers;
    }
}
