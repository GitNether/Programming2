package tl.prog2.exercises.set05;

import java.util.Iterator;

public class SphericalTank implements Tank{
    private double surface;
    private double volume;
    private double radius;
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

    public SphericalTank(double radius){
        this.radius = radius;
        calcSurface(radius);
        calcVolume(radius);
    }

    @Override
    public void calcSurface(double... params) {
        surface = 4*Math.PI*Math.pow(params[0], 2);
    }

    @Override
    public void calcVolume(double... params) {
        volume = (4/3)*Math.PI*Math.pow(params[0], 3);
    }

    @Override
    public double getSurface(){ return surface; }
    @Override
    public double getVolume(){ return volume; }

    @Override
    public String toString(){
        return "Sphere: V: " + volume + " S: " + surface;
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
        return new SphericalTank(radius);
    }
}
