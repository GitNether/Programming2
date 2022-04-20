package tl.prog2.exercises.set03;

import java.util.ArrayList;

public class Tour {
    ArrayList<Location> tour_locations;
    double total_distance;

    public Tour(ArrayList<Location> locs){
        tour_locations = new ArrayList();
        for(Location l : locs){
            tour_locations.add(l);
        }
        calcTotalDistance();
    }

    public void calcTotalDistance(){
        total_distance = 0;
        ArrayList<Location> locs = new ArrayList();
        for (Location l : tour_locations){
            locs.add(new Location(l.x, l.y, l.name));
        }
        Location firstloc = locs.get(0);
        Location loc1 = locs.remove(0);
        Location loc2 = locs.remove(0);
        do{
            total_distance += calcDistance(loc1, loc2);
            loc1 = loc2;
            loc2 = locs.remove(0);
        }while(!locs.isEmpty());
        total_distance += calcDistance(loc2, firstloc);
    }

    public double calcDistance(Location l1, Location l2){
        int dx = Math.abs(l2.x - l1.x);
        int dy = Math.abs(l2.y - l1.y);
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }
}
