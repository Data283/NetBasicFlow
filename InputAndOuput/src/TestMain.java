import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) throws IOException {
        //实例化File类文件， 指明要具体操作的文件
        FileReader fileReader = null;
        try {
            File file = new File("InputAndOutput\\helloTest.txt");

            //提供具体的流
            fileReader = new FileReader(file);

            //数据读入

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //链接的关闭
            if (fileReader != null)
                fileReader.close();
        }
    }
    @Test
    public void getTest() throws IOException {
        BufferedInputStream bip = new BufferedInputStream(new FileInputStream("hello.txt"));
        BufferedReader  br = new BufferedReader(new FileReader("hello.txt"));
        BufferedWriter bw =  new BufferedWriter(new FileWriter("hello1.txt"));
        String data;
        while ((data = br.readLine()) != null){
            bw.write(data);
            bw.newLine();
        }
        if (br != null){
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (bw != null){
            bw.close();
        }

    }

    @Test
    public void input() throws IOException {
        File file = new File("123.png");

        File deskFile =  new File("456.png");

        FileInputStream fileInputStream = new FileInputStream(file);

        FileOutputStream fileOutputStream = new FileOutputStream(deskFile);

        byte[] buffer = new byte[5];
        int len;
        while ((len = fileInputStream.read(buffer)) != -1){
            fileOutputStream.write(buffer,0,len);
        }

        fileInputStream.close();
        fileOutputStream.close();

    }

    @Test
    public void PiCTest() throws IOException {
        BufferedInputStream br = new BufferedInputStream(new FileInputStream("123.png"));
        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("234.png"));

        Scanner scanner = new Scanner(System.in);

        byte[] buffer = new byte[10];
        int len;
        while ((len = br.read(buffer)) != -1){
            for (int i = 0; i < len; i++) {
                buffer[i] = (byte) (buffer[i] ^ 5);
            }
            bout.write(buffer);
        }

        if (br != null){
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


}

