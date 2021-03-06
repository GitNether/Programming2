package tl.prog2.exercises.set08;

import java.io.File;
import java.io.IOException;

/**
 * Prints recursively all files which are contained in
 * the current directory or in sub-directories.
 * @author Reinhard Schiedermeier, Ruediger Lunde
 */
public class FlexibleFileTreeWalker {
    FileProcessor processor;
    public FlexibleFileTreeWalker(FileProcessor processor) throws IOException{
        this.processor = processor;
    }
    public FlexibleFileTreeWalker() throws IOException{}

    public static void main(String[] args) throws IOException {
        new FlexibleFileTreeWalker().walk(".");
    }
    public void walk(String pathname) throws IOException {
        File[] files = new File(pathname).listFiles();
        if (files != null) {
            for (File file : files)
                if (file.isDirectory())
                    walk(file.getCanonicalPath());
                else
                    if(processor!=null){
                        processor.process(file);
                    }else {
                       process(file);
                    }
        }
    }
    protected void process(File file) throws IOException {
        System.out.printf("%-100s%6d%n", file.getCanonicalPath(),
                file.length());
    }

    static interface FileProcessor{
        void process(File file) throws IOException;
    }
}
