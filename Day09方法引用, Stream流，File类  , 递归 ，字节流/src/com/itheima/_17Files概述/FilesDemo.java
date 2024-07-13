package com.itheima._17Files概述;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
    目标：Files类的概述和API，从jdk1.7开始支持

     Java NIO Files 类(java.nio.file.Files)提供了几种操作文件系统中的文件的方法。
    以下内容介绍 Java NIO Files 最常用的一些方法。java.nio.file.Files 类与
     java.nio.file.Path 实例一起工作，因此在学习 Files 类之前，需要先了解 Path 类



    Files类常用的静态方法API:
         （1）用于根据 Path 实例创建一个新目录并返回 Path
               --  public static Path createDirectories(Path dir, FileAttribute<?>... attrs) throws IOException{}

         （2）拷贝一个文件到另外一个目录，第三个参数options。如果目标文件已经存在，这个参数StandardCopyOption.REPLACE_EXISTING指示 copy()方法覆盖现有的文件
               --  public static Path copy(Path source, Path target, CopyOption... options) throws IOException{}

         （3）拷贝一个文件内容到另一个文件上
               -- public static long copy(Path source, OutputStream out){}

         （4）用于将文件从一个路径移动到另一个路径。移动文件与重命名相同，但是移动文件既可以移动到不同的目录，也可以在相同的操作中更改它的名称
               --  public static Path move(Path source, Path target, CopyOption... options) throws IOException{}

         （5）可以删除一个文件或者空的目录，部位空的目录不能删除（防止程序恶意删除window文件，因为程序删除是不进入到回收站的）
               --  public static void delete(Path path) throws IOException {} // 如果文件或者目录不存在，删除的话报错
               --  public static boolean deleteIfExists(Path path) throws IOException{} // 如果文件或者目录不存在，删除的话不报错

         （6）包含递归遍历目录树功能，将 Path 实例和 FileVisitor作为参数。Path 实例指向要遍历的目录，FileVisitor 在遍历期间被调用
               --  public static Path walkFileTree(Path start, FileVisitor<? super Path> visitor) throws IOException{}

         （7） 读取一个路径下的文件内所有数据，一行一行读取，并返回一个List集合，集合中每个元素是文件中的一行字符串。默认以UTF-8编码读取文件数据
               --  public static List<String> readAllLines(Path path) throws IOException {}
               --   public static List<String> readAllLines(Path path, Charset cs) throws IOException {}  // 指定编码读取文件数据返回一个List集合，可以是 GBK 编码等



 */
public class FilesDemo {
    public static void main(String[] args) {
//        // 1.给定一个路径创建一个不存在的目录，
//        // TODO 如果创建的目录存在报错（FileAlreadyExistsException）或者父目录不存在报错（NoSuchFileException）
//        Path path = Paths.get("F:\\datas\\data\\a");
//        try {
//            Path directory = Files.createDirectory(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        // 2.从源路径拷贝一个文件到目标路径下
        // 第三个是可变参数，如果目标路径存在该文件，可以用StandardCopyOption.REPLACE_EXISTING参数覆盖该文件
        Path path1 = Paths.get("F:\\datas\\data\\1.txt");
        Path path2 = Paths.get("F:\\datas\\data\\a\\01.txt");
//        try {
//            // TODO 如果目标路径已存在该文件，则报错 （FileAlreadyExistsException）
//            // TODO 如果目标路径不存在，则报错 （NoSuchFileException）
//            //Path copy = Files.copy(path1, path2);
//            // TODO 第三个是可变参数，如果目标路径存在该文件，可以用StandardCopyOption.REPLACE_EXISTING参数覆盖该文件，即使目标路径文件存在也不报错
//            Path copy = Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 3.用于将文件从源路径移动到目标路径下。
        Path sourcePath = Paths.get("F:\\datas\\data\\1.txt");
        Path destinationPath = Paths.get("F:\\datas\\data\\a\\1test.txt");

//        try {
//            Files.move(sourcePath, destinationPath,StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            //移动文件失败
//            e.printStackTrace();
//        }


        // 4.删除一个文件或者空的目录
//        Path path = Paths.get("F:\\datas\\data\\1.txt");
//        try {
//            //Files.delete(path);  // 删除一个不存在的文件或者空目录报错 NoSuchFileException
//            Files.deleteIfExists(path); // 删除一个不存在的文件或者空目录不报错
//        } catch (IOException e) {
//            // 删除文件失败
//            e.printStackTrace();
//        }

          // 5. 包含递归遍历目录树功能
//        Path rootPath = Paths.get("F:\\datas\\data");
//        String fileToFind = File.separator + "002.txt";
//
//        try {
//            Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
//
//                @Override
//                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                    String fileString = file.toAbsolutePath().toString();
//                    //System.out.println("pathString = " + fileString);
//
//                    if(fileString.endsWith(fileToFind)){
//                        System.out.println("file found at path: " + file.toAbsolutePath());
//                        return FileVisitResult.TERMINATE;
//                    }
//                    return FileVisitResult.CONTINUE;
//                }
//            });
//        } catch(IOException e){
//            e.printStackTrace();
//        }

        // 6.读取指定的文件数据，并返回一个List的集合，一行一行读取文件
        try {
            List<String> lines = Files.readAllLines(Paths.get("F:\\atguigu\\20_尚硅谷大数据技术之Flink\\4.视频\\Day05-Flink高阶编程\\flink课堂笔记.txt"),Charset.forName("GBK"));
            lines.stream()
                    .filter(line -> null != line && line.trim().length()>0)
                    .map(line -> line.trim())
                    .map(line -> line.charAt(0))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
