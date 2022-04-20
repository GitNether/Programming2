package tl.prog2.exercises.set05;

import java.util.Iterator;

public class CylindricalTank implements Tank{
    private double surface;
    private double volume;
    private double height, radius;
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

    public CylindricalTank(double height, double radius){
        this.height = height;
        this.radius = radius;
        calcVolume(height, radius);
        calcSurface(height, radius);
    }

    @Override
    public void calcSurface(double... params) {
        surface = 2*Math.PI*params[1]*(params[1]+params[0]);
    }

    @Override
    public void calcVolume(double... params) {
        volume = 2*Math.PI*params[0]*params[1];
    }

    @Override
    public double getSurface(){ return surface; }
    @Override
    public double getVolume(){ return volume; }

    @Override
    public String toString(){
        return "Cylinder: V: " + volume + " S: " + surface;
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
        return new CylindricalTank(height, radius);
    }
}
