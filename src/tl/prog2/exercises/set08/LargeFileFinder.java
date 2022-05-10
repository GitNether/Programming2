package tl.prog2.exercises.set08;

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class LargeFileFinder {

    class Processor implements FlexibleFileTreeWalker.FileProcessor{

        ArrayList<File> files = new ArrayList();

        @Override
        public void process(File file) throws IOException{
            files.add(file);
        };

        public void sort(){
            files.sort(new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return (int)(o2.length()) - (int)(o1.length());
                }
            });
        }

        public void print() throws IOException{
            for(File f : files) {
                System.out.printf("%-100s%6d%n", f.getCanonicalPath(),
                        f.length());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        LargeFileFinder lff = new LargeFileFinder();
        Processor processor = lff.new Processor();
        FlexibleFileTreeWalker ff = new FlexibleFileTreeWalker(processor);
        ff.walk(".");
        processor.sort();
        processor.print();
    }

}
