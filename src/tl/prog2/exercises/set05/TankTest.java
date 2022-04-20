package tl.prog2.exercises.set05;

import java.util.ArrayList;

public class TankTest {
    ArrayList<Tank> tanks;
    int amount = 0;

    public TankTest(){
        tanks = new ArrayList<Tank>();
    }

    public void add(Tank t){
        tanks.add(t);
    }

    public void printSystem(){
        System.out.println("Total: Tanks: " + getAmount() + " V: " + totalVolume() + " S: " + totalSurface());
        for(Tank t : tanks){
            System.out.println(t.toString());
        }
    }

    public int getAmount(){
        amount = 0;
        for(Tank t : tanks){
            amount += t.getAmount();
        }
        return amount;
    }

    public double totalVolume(){
        double total = 0;
        for(Tank t : tanks){
            total += t.getVolume();
        }
        return total;
    }

    public double totalSurface(){
        double total = 0;
        for(Tank t: tanks){
            total += t.getSurface();
        }
        return total;
    }

    public static void main(String[] args) {
        TankTest tt = new TankTest();

        Tank t1 = new SphericalTank(3);
        Tank t2 = new CylindricalTank(5, 2);
        Tank t3 = new CuboidTank(3, 3, 3);
        CompoundTank tc = new CompoundTank();
        tc.add(t1);
        tc.add(t2);
        tc.add(t3);
        Tank t4 = new SphericalTank(5);
        Tank t5 = new CylindricalTank(3, 5);
        Tank t6 = new CuboidTank(4, 2, 2);

        tt.add(tc);
        tt.add(t4);
        tt.add(t5);
        tt.add(t6);

        tt.printSystem();

        System.out.println("------------");

        CompoundTank tc2 = new CompoundTank();
        Tank t7 = new CuboidTank(1, 2, 3);
        Tank t8 = new CuboidTank(2, 3, 4);
        Tank t9 = new CuboidTank(3, 4, 5);
        tc2.add(t7);
        tc2.add(t8);
        tc2.add(t9);

        System.out.println();
        System.out.println(tc2.toString());
        System.out.println("Clone:");
        CompoundTank tc2clone = tc2.clone();
        System.out.println(tc2clone.toString());
        System.out.println();
        System.out.println("Remove:");
        tc2.remove(1);
        System.out.println(tc2.toString());
        System.out.println("Clone:");
        System.out.println(tc2clone.toString());

    }
}
