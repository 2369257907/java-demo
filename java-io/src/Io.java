import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 86171
 */
public class Io {
    public static void main(String[] args) throws IOException {
        listAllFiles(new File("C:\\Users\\86171\\Desktop\\BANDIZIP-PORTABLE-GL-64BIT (1)"));
        copyFile("C:\\Users\\86171\\Desktop\\src.txt","C:\\Users\\86171\\Desktop\\dist.txt");
        readFileContent("C:\\Users\\86171\\Desktop\\src.txt");
        readFromUrl("https://www.baidu.com");
    }


    /**io磁盘操作
     *
     * 递归列出所有文件的文件名
     *
     * @param dir dir
     */
    public  static void listAllFiles(File dir){
        if (dir == null || !dir.exists()){
            return;
        }
        if (dir.isFile()){
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles()){
            listAllFiles(file);
        }
    }

    /**
     * io字节操作
     *
     * 通过字节流复制文件
     *
     * @param src  src
     * @param dist
     * @throws IOException ioexception
     */
    public static void copyFile(String src, String dist) throws IOException {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);

        byte[] buffer = new byte[20*1024];
        int cnt;
        while ((cnt = (in.read(buffer,0,buffer.length)) )!=-1){
            out.write(buffer,0,cnt);
        }
        in.close();
        out.close();
    }

    public static void readFileContent(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line ;
        while (( line = bufferedReader.readLine() )!=null){
            System.out.println(line);
        }

        // 装饰者模式使得 BufferedReader 组合了一个 Reader 对象
        // 在调用 BufferedReader 的 close() 方法时会去调用 Reader 的 close() 方法
        // 因此只要一个 close() 调用即可
        bufferedReader.close();
    }


    /**
     * io网络操作
     *
     * 读取url对应的页面信息
     *
     * @param DistUrl dist url
     * @throws IOException ioexception
     */
    public static void readFromUrl(String DistUrl) throws IOException {

        //输入流
        URL url = new URL(DistUrl);
        InputStream is = url.openStream();
        //输入流的reader
        InputStreamReader inputStreamReader = new InputStreamReader(is,"utf-8");
        //缓冲区
        BufferedReader br = new BufferedReader(inputStreamReader);
        //打印
        String line;
        while ((line=br.readLine()) != null){
            System.out.println(line);
        }

    }





}


