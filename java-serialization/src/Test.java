import org.omg.CORBA_2_3.portable.OutputStream;

import java.io.*;

/**
 * @author 86171
 */

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建对象

        ZhangSan zhangsan = new ZhangSan("zhangsan", 22);

        serilizeObject(zhangsan, "guo");
        deserlizeObject("guo");
    }


    static void serilizeObject(ZhangSan zhangsan, String outputPath) {
        try {
            System.out.println("===========开始序列化=============");
            System.out.println("序列化的对象是：" + zhangsan);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(outputPath));
            objectOutputStream.writeObject(zhangsan);
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deserlizeObject(String inputPath) {
        try {
            System.out.println("===========开始序列化=============");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(inputPath)));
            ZhangSan zhangsan2 = (ZhangSan) ois.readObject();
            ois.close();
            System.out.println("反序列化的结果是：" + zhangsan2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

