package tl.prog2.exercises.set05;

import java.util.Iterator;

public class CuboidTank implements Tank {
    private double surface;
    private double volume;
    private double length, width, depth;
    private Iterator<Tank> iterator = new Iterator<Tank>() {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Tank next() {
            return null;
        }
    };

    public CuboidTank(double length, double width, double depth){
        this.length = length;
        this.width = width;
        this.depth = depth;
        calcSurface(length, width, depth);
        calcVolume(length, width, depth);
    }

    @Override
    public void calcSurface(double... params) {
        surface = 2*params[0]*params[1] + 2*params[0]*params[2] + 2*params[1]*params[2];
    }

    @Override
    public void calcVolume(double... params) {
        volume = params[0]*params[1]*params[2];
    }

    @Override
    public double getSurface(){ return surface; }
    @Override
    public double getVolume(){ return volume; }

    @Override
    public String toString(){
        return "Cuboid: V: " + volume + " S: " + surface;
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Tank next() {
        return iterator.next();
    }

    @Override
    public int getAmount(){
        return 1;
    }

    @Override
    public Tank clone(){
        return new CuboidTank(length, width, depth);
    }
}
