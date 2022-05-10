package tl.prog2.exercises.set08;

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class DuplicateFileFinder {

    class Processor implements FlexibleFileTreeWalker.FileProcessor{

        ArrayList<File> dupes = new ArrayList();
        HashMap<String, Long> hash = new HashMap<>();

        @Override
        public void process(File file) throws IOException{
            if(hash.containsKey(file.getName())&&(hash.get(file.getName())==file.length())) {
                dupes.add(file);
            }else{
                hash.put(file.getName(), file.length());
            }
        };

        public void print() throws IOException{
            for(File f : dupes) {
                System.out.printf("%-100s%6d%n", f.getCanonicalPath(),
                        f.length());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        DuplicateFileFinder dff = new DuplicateFileFinder();
        Processor processor = dff.new Processor();
        FlexibleFileTreeWalker ff = new FlexibleFileTreeWalker(processor);
        ff.walk(".");
        processor.print();
    }

}
