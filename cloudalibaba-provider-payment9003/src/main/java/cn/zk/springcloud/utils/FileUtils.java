package cn.zk.springcloud.utils;

import java.io.File;
import java.util.Objects;

/**
 * @author zk
 * @version 1.0
 * @description 文件重命名
 * @date 2020/11/11 16:42
 */
public class FileUtils {
    static String folder = "C:/Users/zhongka/Desktop/psImg/pstemp/dpcq/D/斗破苍穹/第870话F0_288938";
    static void gaiFileName(String dir) {
        File file = new File(dir);
        File[] files = file.listFiles();
        if (Objects.nonNull(files) && files.length > 0) {
            for (File file1 : files) {
                if (file1.isDirectory()){
                    continue;
                }else {
                    String fileName = file1.getName();
                    File parentPath = file1.getParentFile();
                    String[] params = fileName.split("\\.");
                    String newName = fileName;//初始值
                    if (params.length>=2){
                        newName = params[0] + "_870.jpg";
                        System.out.println(newName);
                    }
                    File newDir = new File(parentPath + "/" + newName);
                    file1.renameTo(newDir);
                }
            }
        }
    }
    //在main函数中直接调用 gaiFileName(folder);
    public static void main(String[] args) {
        gaiFileName(folder);
    }
}
