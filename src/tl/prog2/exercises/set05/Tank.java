package tl.prog2.exercises.set05;

import java.util.Iterator;

public interface Tank {
    double surface = 0;
    double volume = 0;
    Iterator<Tank> iterator = new Iterator<Tank>() {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Tank next() {
            return null;
        }
    };

    public void calcSurface(double... params);
    public void calcVolume(double... params);
    public double getSurface();
    public double getVolume();
    public String toString();
    public Tank next();
    public boolean hasNext();
    public int getAmount();
    public Tank clone();
}
