package Test_1;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void main(String[] args) {
        Path paths=Paths.get("C:\\Users\\lyx\\IdeaProjects\\CodeTest\\hello.txt");
        System.out.println(paths.getFileName());
        System.out.println(paths.getParent());
        System.out.println(paths.getRoot());
        System.out.println(paths.getFileSystem());



    }
}
