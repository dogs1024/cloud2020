import org.junit.Test;

import java.io.File;

/**
 * @author zk
 * @version 1.0
 * @description
 * @date 2020/11/11 16:07
 */
public class TestFileReName {
//    public static void main(String[] args)
    public void test1()
    {
        File file = new File("C:/Users/zhongka/Desktop/psImg/pstemp/dpcq/D/斗破苍穹/第869话F0_287933");
        File[] list = file.listFiles();

        // 如果目录下文件存在
        if (file.exists() && file.isDirectory())
        {
            for (int i = 0; i < list.length; i++)
            {
                //取文件名字存入name中
                String name = list[i].getName();
                // 截取.之前的字符串出来
                int index = name.indexOf(".");
                // 截取.JPG出来
                int index2 = name.lastIndexOf(".");
                String name3 = name.substring(index2);
                // 拼接字符串
//                String newName = "2016-4-15-" + (i + 1) + name3;
                // 修改后缀名1.jpg-smh.middle --> 1.jpg
                String name1 = name.substring(index);
                String newName = "2016-4-15-" + (i + 1) + name3;
                //重命名
                File dest = new File("C:/Users/zhongka/Desktop/psImg/pstemp/dpcq/D/斗破苍穹/第869话F0_287933" + "/" + newName);
                list[i].renameTo(dest);
                System.out.println(dest.getName());
            }
        }
    }

//    @Test
//    public void updateFileName()
    public static void main(String[] args)
    {
        File file = new File("C:/Users/zhongka/Desktop/psImg/pstemp/dpcq/test");
        File[] list = file.listFiles();

        // 如果目录下文件存在
        if (file.exists() && file.isDirectory())
        {
            for (int i = 0; i < list.length; i++)
            {
                //取文件名子存入name中
                String name = list[i].getName();
                // 截取.之前的字符串出来
                int index = name.indexOf(".");
                String name3 = name.substring(0,index);
                // 拼接字符串
                String newName = name3+"_869.jpg";
                //重命名
                File dest = new File("d:/photos" + "/" + newName);
                list[i].renameTo(dest);
                System.out.println(dest.getName());
            }
        }
    }
}
