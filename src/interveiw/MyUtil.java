package interveiw;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Class: MyUtil
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/5/28
 */
public class MyUtil {

    // 工具类中的方法都是静态方式访问的因此将构造器私有不允许创建对象(绝对好习惯)
    public MyUtil() {
        throw new AssertionError();
    }

    public static  <T extends Serializable> T clone(T obj) throws Exception{
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);){
            oos.writeObject(obj);

            try (ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                 ObjectInputStream ois = new ObjectInputStream(bis);){
                T target = (T)ois.readObject();
                return target;
            }
        }
    }

    public static void fileCopy(String source, String target) throws IOException {
        try(FileInputStream in = new FileInputStream(source)){
            try (FileOutputStream out = new FileOutputStream(target)){
                byte[] buffer = new byte[4096];
                int byteToRead;
                while ((byteToRead = in.read(buffer)) != -1)
                    out.write(buffer, 0, byteToRead);
            }
        }
    }


    public static void fileCopyNIO(String source, String target) throws IOException {
        try(FileInputStream in = new FileInputStream(source)){
            try (FileOutputStream out = new FileOutputStream(target)){
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);

                while (inChannel.read(buffer) != -1){
                    buffer.flip();  // 回绕缓冲区，从数据开头读取
                    outChannel.write(buffer);
                    buffer.clear(); // 清空缓冲区
                }

            }
        }
    }

    /**
     * @Description:
     * @param filename
     * @param word
     * @return: int 字符串在文件中出现的次数
     * @Author: Jiang Chao
     * @Date: 2018/6/2
     * @Version: 1.0
     */

    public static int countWordInFile(String filename, String word){

        int count = 0;
        try (FileReader fr = new FileReader(filename)){
            try (BufferedReader reader = new BufferedReader(fr)){
                String line = null;
                while ((line = reader.readLine()) != null){
                    int index = -1;
                    while (line.length() > word.length() && (index = line.indexOf(word)) > 0){
                        count++;
                        line = line.substring(index + word.length());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

}
