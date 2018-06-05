package interveiw;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @Class: FilePrint
 * @Description: 打印文件夹文件
 * @Author: Jiang Chao
 * @Date: 2018/6/2
 */
public class FilePrint {


    public FilePrint() {
        throw new AssertionError();
    }

    public static void showDirectory(File f) throws IOException {
        // 方法一：递归调用
//        walkDirectory(f, 0);

        // 方法二, 在Java 7中可以使用NIO.2的API来做同样的事情
        Path path = Paths.get("G:\\DataScience");
        Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.getFileName().toString());
                return FileVisitResult.CONTINUE;
            }
        });

    }

    public static void walkDirectory(File file, int level){
        if (file.isDirectory())
        {
            for (File f : file.listFiles())
                walkDirectory(f, level + 1);
        }
        else {
            for (int i = 0; i < level - 1; i++)
            {
                System.out.print("\t");
            }
            System.out.println(file.getName());
        }
    }



    public static void main(String[] args) throws IOException {
        showDirectory(new File("G:\\DataScience"));
    }
}
