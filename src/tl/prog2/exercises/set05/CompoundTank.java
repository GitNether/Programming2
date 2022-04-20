package tl.prog2.exercises.set05;

import java.util.ArrayList;
import java.util.Iterator;

public class CompoundTank implements Tank{
    private double surface = 0;
    private double volume = 0;
    ArrayList<Tank> tanks;
    private Iterator<Tank> iterator;

    public CompoundTank(){
        tanks = new ArrayList<Tank>();
    }

    public void add(Tank part){
        tanks.add(part);
        calcVolume();
        calcSurface();
        iterator = tanks.iterator();
    }

    @Override
    public void calcSurface(double... params) {
        surface = 0;
        for(Tank t : tanks){
            surface += t.getSurface();
        }
    }

    @Override
    public void calcVolume(double... params) {
        volume = 0;
        for(Tank t : tanks){
            volume += t.getVolume();
        }
    }

    @Override
    public double getSurface(){ return surface; }
    @Override
    public double getVolume(){ return volume; }

    @Override
    public String toString(){
        String s = "Compound: " + tanks.size() + " Tanks:";
        for(Tank t : tanks){
            s += "\n" + t.toString();
        }
        s += "\n---------";
        return s;
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Tank next() {
        return iterator.next();
    }

    public Tank remove(int i){
        return tanks.remove(i);
    }

    @Override
    public int getAmount(){
        return tanks.size();
    }

    @Override
    public CompoundTank clone(){
        CompoundTank ct = new CompoundTank();
        for(Tank t : tanks){
            ct.add(t.clone());
        }
        return ct;
    }
}
