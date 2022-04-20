package tl.prog2.exercises.set03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TSP {
    ArrayList<Location> tsp_locations = new ArrayList();
    ArrayList<Tour> tsp_tours = new ArrayList();

    public TSP() {
        int loc_count;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter the amount of Locations your TSP has: ");
            loc_count = scanner.nextInt();
            if(loc_count < 3){
                System.out.println("Please enter a valid amount!");
            }
        } while (loc_count < 3);

        for (int i = 1; i <= loc_count; i++) {
            System.out.print("Location " + i + " Name: ");
            String name = scanner.next();
            System.out.print("Location " + i + " X Coordinate: ");
            int x = scanner.nextInt();
            System.out.print("Location " + i + " Y Coordinate: ");
            int y = scanner.nextInt();
            Location loc = new Location(x, y, name);
            tsp_locations.add(loc);
        }
    }

    public TSP(ArrayList<Location> locs){
        tsp_locations = locs;
    }

    public static void main(String[] args) {
        //TSP tsp = new TSP();  // <-- Input own Locations

        Scanner scanner = new Scanner(System.in);
        int index;
        do{
            System.out.print("Enter TSP Index: ");
            index = scanner.nextInt();
            if(index<1||index>3){System.out.println("Please enter a valid Index!");}
        }while(index<1||index>3);
        ArrayList<Location> locs = new ArrayList<>();
        switch(index){
            case 1:
                locs.add(new Location(0, 0, "A"));
                locs.add(new Location(0, 1, "B"));
                locs.add(new Location(1, 0, "C"));
                locs.add(new Location(1, 1, "D"));
                locs.add(new Location(2, 0, "E"));
                locs.add(new Location(2, 1, "F"));
                break;
            case 2:
                locs.add(new Location(0, 0, "A"));
                locs.add(new Location(0, 1, "B"));
                locs.add(new Location(0, 2, "C"));
                locs.add(new Location(0, 3, "D"));
                locs.add(new Location(1, 1, "E"));
                locs.add(new Location(1, 2, "F"));
                locs.add(new Location(3, 0, "G"));
                locs.add(new Location(3, 3, "H"));
                locs.add(new Location(3, 4, "I"));
                locs.add(new Location(3, 5, "J"));
                locs.add(new Location(3, 6, "K"));
                break;
            case 3:
                locs.add(new Location(0, 0, "A"));
                locs.add(new Location(0, 1, "B"));
                locs.add(new Location(0, 2, "C"));
                locs.add(new Location(0, 3, "D"));
                locs.add(new Location(1, 1, "E"));
                locs.add(new Location(1, 2, "F"));
                locs.add(new Location(3, 0, "G"));
                locs.add(new Location(3, 3, "H"));
                locs.add(new Location(3, 4, "I"));
                locs.add(new Location(3, 5, "J"));
                locs.add(new Location(3, 6, "K"));
                locs.add(new Location(4, 0, "L"));
                locs.add(new Location(4, 3, "M"));
                locs.add(new Location(4, 4, "N"));
                locs.add(new Location(4, 5, "O"));
                break;
        }
        TSP tsp = new TSP(locs);
        tsp.printTSP();

        System.out.println("Picking one out of " + tsp.fact(locs.size()) + " Tours using the Greedy Algorithm...");
        Tour greedy = tsp.greedy();
        System.out.println("Greedy Tour:");
        tsp.printTour(greedy);

        //System.out.println("Calculating all Tours...");
        //tsp.permuteTours(tsp.tsp_locations);
        //System.out.println(tsp.tsp_tours.size() + " Tours found!");
        //System.out.println("Evaluating cheapest Tour...");
        //Tour min = tsp.evaluateTours();
        //System.out.println("Cheapest Tour: ");
        //tsp.printTour(min);
        //System.out.println();
    }

    public Tour greedy(){
        ArrayList<Location> locs = new ArrayList();
        ArrayList<Location> t = new ArrayList();
        for (Location l : tsp_locations){
            locs.add(l);
        }
        Location firstLoc = locs.remove(0);
        Location loc = firstLoc;
        t.add(firstLoc);
        while(!locs.isEmpty()){
            double min = Double.POSITIVE_INFINITY;
            Location nextLoc = loc;
            for(Location l : locs){
                double d = calcDistance(nextLoc, l);
                if(d<min){
                    min = d;
                    loc = l;
                }
            }
            Location temp = locs.remove(locs.indexOf(loc));
            t.add(temp);
        }
        Tour tour = new Tour(t);
        return tour;
    }

    public double calcDistance(Location l1, Location l2){
        int dx = Math.abs(l2.x - l1.x);
        int dy = Math.abs(l2.y - l1.y);
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public long fact(int n){
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public void printTour(Tour t){
        System.out.print("Distance: " + t.total_distance + " | ");
        ArrayList<Location> locs  = new ArrayList();
        for (Location l : t.tour_locations){
            locs.add(new Location(l.x, l.y, l.name));
        }
        Location firstloc = t.tour_locations.get(0);
        while(!locs.isEmpty()){
            Location nextloc = locs.remove(0);
            System.out.print(nextloc.name + " - ");
        }
        System.out.println(firstloc.name);
    }

    public void printTSP(){
        int i = 1;
        ArrayList<Location> locs = new ArrayList();
        for (Location l : tsp_locations){
            locs.add(new Location(l.x, l.y, l.name));
        }
        while(!locs.isEmpty()){
            Location loc = locs.remove(0);
            System.out.println("#" + i + " | " + loc.name + " | X: " + loc.x + " | Y: " + loc.y);
            i++;
        }
    }

    /*
    public void permuteTours(ArrayList<Location> locs) {
        Location firstLoc = locs.get(0);
        ArrayList<Location> list = new ArrayList();
        for (Location l : locs){
            list.add(new Location(l.x, l.y, l.name));
        }
        ArrayList<ArrayList<Location>> result = new ArrayList<ArrayList<Location>>();

        result.add(new ArrayList<Location>());

        for (int i = 0; i < list.size(); i++) {
            ArrayList<ArrayList<Location>> current = new ArrayList<ArrayList<Location>>();

            for (ArrayList<Location> l : result) {
                for (int j = 0; j < l.size()+1; j++) {
                    l.add(j, list.get(i));

                    ArrayList<Location> temp = new ArrayList<Location>(l);
                    current.add(temp);

                    l.remove(j);
                }
            }

            result = new ArrayList<ArrayList<Location>>(current);
        }

        for (ArrayList<Location> r : result){
            Tour t = new Tour(r);
            tsp_tours.add(t);
        }

        ArrayList<Tour> tours = new ArrayList<>();
        for (Tour tour : tsp_tours){
            if(tour.tour_locations.get(0).name == firstLoc.name) {
               tours.add(tour);
            }
        }
        tsp_tours = tours;
    }
    */
    /*
    public Tour evaluateTours(){
        Tour minTour = null;
        double min = Double.POSITIVE_INFINITY;
        for (Tour t: tsp_tours){
            if(t.total_distance<min){
                min=t.total_distance;
                minTour=t;
            }
        }
        return minTour;
    }
    */
}