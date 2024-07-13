package com.itheima._02字节缓冲流做文件夹的复制;

import java.io.*;

/**
    目标：io流实现文件夹与文件内容的复制。

    需要被复制的源目录：F:\datas\data
    复制到目标目录：F:\testfile下

    小结：
        高级的字节缓冲流按照一个一个字节数组的形式复制性能极高，建议以后使用！
 */
public class CopyDirectoryDemo {
    public static void main(String[] args) {
        // 定义一个源文件对象
        File srcFile = new File("F:\\datas\\data\\");

        // 定义一个目标文件对象
        File destFile = new File("F:\\testfile");


        // 调用拷贝文件夹与文件内容独立方法
        copyDirectory(srcFile,destFile);

    }


    /**
     * 复制文件夹的独立方法
     * @param srcFile
     * @param destFile
     */
    public static void copyDirectory(File srcFile, File destFile){
        // 1.判断srcFile是否是一个已存在 且 为目录 的文件对象
        if (srcFile.exists() && srcFile.isDirectory()){
            // 如果srcFile文件对象的路径是目录，则在目标destFile文件对象的路径下创建新的目标路径（F:\testfile\data）的文件对象
            String newDestDir = destFile.getAbsolutePath() + File.separator + srcFile.getName();
            File newDestFile = new File(newDestDir);
            // 如果（F:\testfile\data）目录不存在。则创建
            if (!newDestFile.exists()){
                newDestFile.mkdirs();
            }

            // 获取data目录下所有一级文件对象
            File[] files = srcFile.listFiles();
            if (files !=null && files.length >0){
                // 遍历data目录下所有一级文件对象
                for (File oneFile : files) {
                    // 如果一级文件对象为文件的话用  缓冲字节流  复制该文件
                    if (oneFile.isFile()){
                        copyFile(oneFile,new File(newDestDir,oneFile.getName()));
                    }else{
                        // 如果 F:\datas\data的一级文件对象是目录的话，则在新的目标路径（F:\testfile\data）下创建目录，递归调用
                        copyDirectory(oneFile,newDestFile);
                    }
                }
            }

            // 2.如果srcFile是一个已存在 且 为文件 的文件对象，则用用  缓冲字节流  复制该文件
        }else if (srcFile.exists() && srcFile.isFile()){
            // 如果目标文件对象的目录（F:\testfile）不存在的话则创建目录
            if (!destFile.exists()){
                destFile.mkdirs();
            }
            copyFile(srcFile,new File(destFile,srcFile.getName()));
        } else{
            // 3.否则源文件对象的路径不存在
            System.err.println("您给的源文件对象的路径不存在，请重新检查");
        }
    }

    /**
     * 复制文件的独立方法
     * @param srcFile
     * @param destFile
     */
    public static void copyFile(File srcFile, File destFile){
        try(
                // 1.创建一个低级的字节输入流与源文件接通
                InputStream is = new FileInputStream(srcFile);
                BufferedInputStream bis = new BufferedInputStream(is);
                // 2.创建一个低级的字节输出流管道与目标文件接通
                OutputStream os = new FileOutputStream(destFile);
                BufferedOutputStream bos = new BufferedOutputStream(os);
        ){
            // 3.定义一个字节数组存储字节
            byte[] buffer = new byte[1024];
            // 定义一个变量存储每次读取的字节数量。
            int len ;
            while((len = bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
